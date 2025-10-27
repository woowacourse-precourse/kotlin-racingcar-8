# kotlin-racingcar-precourse

# 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```text
pobi,woni,jun
```

- 시도할 횟수

```text
5
```

### 출력

- 차수별 실행 결과

```text
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```text
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```text
최종 우승자 : pobi, jun
```

### 실행 결과 예시

```text
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

# 프로그래밍 요구 사항1

- Kotlin 2.2.0에서 실행 가능해야 한다.
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle.kts` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()` 또는 `exitProcess()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Kotlin Style Guide](http://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/kotlin)를 원칙으로 한다.

# 프로그래밍 요구 사항2

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://docs.junit.org/current/user-guide/)
        - [AssertJ User Guide](https://assertj.github.io/doc/)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

## 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환

```kotlin
Randoms.pickNumberInRange(0, 9)
```

# 구현할 기능 목록
1. **입출력**
    - [ ] `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 문구를 출력한 후 사용자 입력을 받는다.
    - [ ] `시도할 횟수는 몇 회인가요?` 문구를 출력한 후 사용자 입력을 받는다.
    - [ ] `실행 결과` 헤더 문구를 출력한다.
    - [ ] 각 라운드 종료 후, 모든 자동차의 이름과 현재 위치(`-` 개수)를 형식에 맞춰 출력하고, 라운드 사이에 빈 줄을 추가한다.
      - (예시) `pobi : --`
    - [ ] 모든 라운드 종료 후, `최종 우승자 : 이름1[, 이름2, ...]` 형식으로 최종 우승자를 출력한다.

2. **유효성 검증 및 데이터 처리**
   - **자동차 이름**:
        - [ ] 입력받은 이름을 쉼표(,) 기준으로 분리한다.
        - [ ] 각 이름의 길이가 **1자 이상 5자 이하**인지 검증한다.
        - [ ] 이름이 공백으로만 이루어져 있는지 검증한다.
        - [ ] 이름 목록이 비어있지 않은지 검증한다.
   - **시도 횟수**:
     - [ ] 입력받은 값이 숫자로 변환 가능한지 검증한다.
     - [ ] 변환된 숫자가 **1 이상의 양수**인지 검증한다.
   - **오류 처리**:
     - [ ] 모든 유효성 검증 실패 시, `IllegalArgumentException`을 발생시키고 애플리케이션을 종료시킨다.

3. **경주 로직**
   - [ ] 검증된 자동차 이름 목록으로 각 자동차 객체를 생성한다.
   - [ ] 검증된 시도 횟수만큼 다음 라운드 진행 로직을 반복한다.
   - **라운드 진행**:
     - [ ] 각 자동차마다 **0에서 9 사이의 무작위 값**을 생성한다.
     - [ ] 무작위 값이 **4 이상**이면 해당 자동차를 전진시킨다.
   - **우승자 판별**:
     - [ ] 모든 라운드 종료 후, 자동차 목록에서 가장 높은 `position` 값을 찾는다.
     - [ ] 해당 `position` 값을 가진 모든 자동차의 이름 목록을 추출한다.
