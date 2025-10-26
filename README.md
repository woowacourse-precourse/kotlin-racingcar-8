# kotlin-racingcar-precourse

## 서비스 소개
주어진 횟수 동안 여러 대의 자동차를 전진시켜 우승자를 가리는 콘솔 자동차 경주 게임입니다.

## 구현할 기능 목록

* [x] **Model (도메인):** 비즈니스 로직 및 데이터
    * [x] `Car`: 이름과 위치를 가진 불변 데이터 클래스 구현
    * [x] `MoveStrategy`: 자동차의 전진 여부를 결정하는 전략 인터페이스 구현
    * [x] `RacingGameValidator`: 사용자 입력(차 이름, 시도 횟수)의 유효성을 검증하는 객체 구현
    * [x] `RacingGame`: 자동차 목록을 소유하고, 1회 경주를 실행하며 우승자를 찾는 객체 구현
* [x] **View (입출력):** 콘솔 입출력 전담
    * [x] `InputView`: 사용자로부터 자동차 이름, 시도 횟수 입력을 받는 객체 구현
    * [x] `OutputView`: 콘솔에 라운드별 실행 결과와 최종 우승자를 출력하는 객체 구현
* [x] **ViewModel (중재자):** View와 Model 사이의 상태 관리 및 로직 컨트롤
    * [x] `RacingGameViewModel`: View의 요청을 받아 Model을 호출하고, 전체 게임의 흐름을 제어하는 클래스 구현
* [x] **Application (조립):**
    * [x] `main` 함수: View, ViewModel, Model(및 전략)을 조립하고 실행 흐름 제어
* [ ] **Test:**
    * [ ] 도메인(Model) 및 ViewModel에 대한 JUnit 5, AssertJ 단위 테스트 코드 작성


## 고민과 결정

### 1. 어떤 아키텍처를 선택할 것인가?

* **고민:** 미션 요구사항인 "indent depth 2 이하", "작은 함수"를 지키면서 '테스트 가능한 코드'를 어떻게 작성할 것인가?
* **결정:** MVVM(Model-View-ViewModel) 패턴의 '관심사 분리' 개념을 적용합니다.
* **근거:**
    1.  **테스트 용이성:** 테스트가 불가능한 `camp.nextstep.edu.missionutils.Console` API를 `View` 계층에 격리시킵니다.
    2.  **테스트 가능성:** `Console`에 의존하지 않는 순수 Kotlin 코드인 `Model`과 `ViewModel`은 100% 단위 테스트가 가능해집니다.
    3.  **가독성 및 책임 분리:** `Application.kt`의 `main` 함수가 모든 로직을 수행하는 대신, `ViewModel`에 로직을 위임하고 `View`에 출력을 위임함으로써, 각자의 책임이 명확해지고 indent depth를 자연스럽게 낮출 수 있습니다. `Application.kt`는 모든 객체를 생성하고 의존성을 연결하는 객체 구성자 역할만 수행합니다.

### 2. `Car`의 상태 관리: 불변 객체 vs. 내부 상태 변경

* **고민:** `Car`의 `position`을 어떻게 관리할지 두 가지 방식을 두고 고민했습니다.
    * **대안 1 (내부 상태 변경):** `private var _position`을 두고 `val position`으로 노출하는 '백킹 프로퍼티(Backing Property)' 방식.
    * **대안 2 (불변 객체):** `val position`을 가진 `data class`를 사용하고, '전진' 시 `copy()`로 새 객체를 반환하는 함수형 접근.
* **결정:** 대안 2 (불변 `data class`)를 선택했습니다.
* **근거1:** 이 결정의 가장 큰 이유는 '테스트 용이성'입니다.
    * '백킹 프로퍼티' 방식은 `move()` 실행 후, 객체의 내부 상태가 변했는지 검증해야 합니다.
    * 반면 '불변' 방식은 `move()`가 '새로운 `Car` 객체'를 반환하므로, "반환된 값이 기대값과 같은지"만 검증하면 됩니다. 이는 미션의 테스트 요구사항을 훨씬 명확하고 단순하게 충족시킵니다.
* **근거2:**
    * `data class`는 `equals()`, `hashCode()`, `toString()`을 자동으로 구현해 '값' 기반 비교와 디버깅을 쉽게 해줍니다.
    * `val`과 불변 객체를 우선시하는 코틀린의 철학에 더 부합하며, `Side Effect`가 없는 코드는 프로그램 전체의 안정성과 멱등성을 보장해주기에 선택했습니다.

### 3. '전진 조건'(랜덤 숫자)을 어떻게 분리할 것인가?

* **고민:** `Car.move()` 함수가 직접 `Randoms.pickNumberInRange()`를 호출해야 하는가?
* **결정:** `MoveStrategy` 인터페이스를 정의하고 외부에서 주입받습니다.
* **근거:** `Car` 객체가 `Randoms`라는 구체적인 라이브러리에 직접 의존하게 되면 테스트가 불가능해집니다. `MoveStrategy` 인터페이스에 의존하게 하면, 실제 실행 시에는 `RandomStrategy`를, 테스트 시에는 `FakeStrategy(true)` 또는 `FakeStrategy(false)`를 주입하여 `Car`의 `move` 로직을 100% 검증할 수 있습니다.

### 4. 예외 처리는 어디서 담당할 것인가?

* **고민:** `IllegalArgumentException` 발생 시 애플리케이션을 종료해야 합니다. 이 로직은 어디에 위치해야 할지 고민했습니다.
* **결정:**
    1.  **검증:** `Model` 계층의 `RacingGameValidator`가 입력값 검증을 수행하고, 실패 시 `IllegalArgumentException`을 `throw`합니다.
    2.  **처리:** `Application.kt`의 `main` 함수에서 `try-catch` 블록으로 이 예외를 잡아 `OutputView.printError()`를 호출합니다.
* **근거:** 도메인 로직은 자신의 규칙(e.g., '이름은 5자 이하')을 어겼을 때 예외를 던지는 책임만 집니다. 이 예외를 '어떻게 처리할지'는 UI/Application 흐름을 제어하는 `main` 함수의 책임이라고 생각했습니다.

### 5. 우승자 판별 로직은 어디에 둘 것인가?

* **고민:** 최종 우승자를 결정하는 책임은 누가 가져야 하는가?
    * **대안 1:** `ViewModel`이 `RacingGame`으로부터 자동차 목록을 받아와, 직접 우승자를 계산하고 UI 상태를 업데이트한다.
    * **대안 2:** `RacingGame`이 스스로의 상태(자동차 목록)를 보고 우승자를 결정하여 `List<Car>` 형태로 반환하는 `findWinners()` 메서드를 제공한다.
* **결정:** **대안 2**를 선택합니다. `RacingGame`이 우승자를 결정하는 책임을 갖도록 합니다.
* **근거:** '우승자를 찾는 것'은 경주 게임의 핵심 비즈니스 규칙입니다. 따라서 이 책임은 `ViewModel`이 아닌 `RacingGame`이 직접 수행하는 것이 더 높은 응집도를 가집니다. `ViewModel`은 `RacingGame`으로부터 우승자 목록을 전달받아 `View`에 보여주기 위한 데이터로 가공하는 역할에만 집중하는 것이 책임의 범위라고 생각했습니다.

### 6. ViewModel의 테스트 용이성 확보

* **고민:** `ViewModel`이 `RacingGameValidator`와 같은 구체적인 구현에 직접 의존하도록 설계했었습니다, 그러나 강한 결합이 생겨 `ViewModel`만을 독립적으로 테스트하기 어렵다고 판단했습니다.
* **결정:** `GameValidator` 인터페이스를 정의하고, `ViewModel`이 생성자를 통해 해당 인터페이스를 주입받도록 변경합니다.
* **근거:** 의존성 역전 원칙을 적용하여, `ViewModel`은 구체 클래스가 아닌 추상 인터페이스에만 의존하게 됩니다. 이를 통해 테스트 시에는 실제 `Validator` 대신 가짜 객체를 쉽게 주입할 수 있어, `ViewModel`의 테스트 용이성이 극대화됩니다.
