# kotlin-racingcar-precourse

## 노션에서 보기
- [Notion Link](https://myknow.notion.site/2-28c406c3c488818ba2e4ec884472d847?source=copy_link)

# 구현

## 흐름

1. 자동차의 이름 문자열(carName, 임시명칭)과 시도 횟수(round, 임시명칭)를 입력 받는다.
2. 입력값 Validation을 진행한다.
    1. 자동차 이름 문자열이 올바른 입력이라면 Parsing하여 List에 저장한다.
    2. 문자열 또는 시도 횟수가 올바른 입력이 아닌 경우 `IllegalArgumentException` 오류를 발생시키고 종료한다.
        1. 올바른 자동차의 이름 문자열이 아닌 경우
        2. 올바른 시도 횟수가 아닌 경우
3. round회 동안
    1. 각 차량마다 Randoms 함수를 통해 정수를 할당한다.
    2. 해당 정수가 4 이상인 지 확인한다.
        1. 4 이상이라면 전진 성공이므로, 위치 값을 증가시킨다.
        2. 4 미만이라면 전진 실패이므로, 그대로 둔다.
4. 자동차 중에서 위치 값이 가장 높은 것을 찾는다.
    1. 하나일 경우 바로 고정 포맷 뒤에 더하여 출력한다.
    2. 복수일 경우 포맷 뒤에 “`,` ”로 join한 결과를 더하여 출력한다.

## 설계

- 예시에 따르면 2번에 걸쳐서 입력을 받게 된다.

    ```
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    ```

    ```
    시도할 횟수는 몇 회인가요?
    5
    ```

    - 두 입력 다 빈 문자열이 들어오면 잘못된 입력으로 처리해야 하니, 동일한 함수에 다른 매개변수로, 입력을 안내하고 결과를 받으면 될 것 같다.(`readNonEmptyLine`)
    - 각 입력에 대해 Validation을 진행하고
        - 자동차 이름은 List<String>으로 반환한다. (`splitWithDelimiters`)
        - 시도 횟수는 Int로 반환한다. (`parseInt`)
    - Round회 동안 순회를 하는데(`Game.playAllRounds`)
        - 각 차량마다(`Car.playRound`)
            - 0부터 9까지 범위에서 랜덤한 값을 뽑아서(`generateRandomValue`)
            - 4 이상이 나온다면 (`isNotLessThanThreshold`)
                - 현재 차량의 위치 값을 1 증가시킨다. (`~~increasePosition~~` position++로 대체)
        - 그리고 현재 각 차량의 상태를 출력한다. (`printCarStatus`)
    - 이후 자동차 중에서 가장 위치 값이 높은 차량들을 찾아내고 (`findWinnerNames`)
    - 이 리스트를 `,` 로 join하여 포맷에 맞게 출력한다. (`printWinners`)

## 기능 목록

[기능 목록 데이터베이스](https://myknow.notion.site/293406c3c4888093b755d12fdc21bc2c?source=copy_link)

- [x]  readNonEmptyLine
- [x]  splitWithDelimiters
- [x]  parseInt
- [x]  validateCarName
- [x]  validateRound
- [x]  printCarStatus
- [x]  printRounds
- [x]  printWinners
- [x]  tryMove
- [x]  isNotLessThanThreshold
- [x]  createCars
- [x]  createRound
- [x]  playRound
- [x]  playAllRounds
- [x]  findWinnerNames

---

# 후기

## 느낀 점

- 이번 과제를 진행하면서, 코드를 최대한 간결하고 명확하게 작성하기 위해 많은 고민을 하였다.
- 특히 반복되는 보일러플레이트를 제거하고, 각 클래스와 함수가 단일 책임(SRP)을 갖도록 설계하는 데 집중하였다.
- 단위 테스트를 고려하여 함수 구조와 매개변수를 설계함으로써, 테스트 가능성과 유지보수성을 동시에 높일 수 있었다.

## 배운 점

1. `JUnit5`과 `AssertJ`의 역할
    - `JUnit5`: 테스트 실행 환경 제공
        - Annotations


| **애너테이션** | **설명** |
| --- | --- |
| **@Test** | 테스트 메서드를 표시. main()처럼 JUnit이 실행 대상으로 인식함. |
| **@BeforeEach** | 각 테스트 실행 **직전에 한 번씩** 실행되는 메서드. 주로 공통 초기화용. |
| **@AfterEach** | 각 테스트 실행 **직후에 한 번씩** 실행되는 메서드. 리소스 정리용. |
| **@BeforeAll** | 테스트 클래스 시작 시 **딱 한 번만** 실행. 주로 전역 설정용 (static 필요). |
| **@AfterAll** | 모든 테스트가 끝난 뒤 **딱 한 번만** 실행. 리소스 전체 정리용. |
| **@DisplayName(”…”)** | 테스트 이름을 사람이 읽기 좋게 지정. 테스트 리포트에서 그대로 표시됨. |
| **@Nested** | 내부 클래스로 **테스트 그룹화** 가능. 관련된 테스트를 묶어 가독성 향상. |
| **@Disabled** | 테스트 일시 비활성화. (임시로 빌드 제외하고 싶을 때 사용) |
| **@ParameterizedTest** | 매개변수 기반 테스트. 여러 입력값으로 같은 테스트 반복 가능. |
| **@ValueSource / @CsvSource** | @ParameterizedTest에 전달할 값 지정. (단일값 / CSV 형태) |
| **@Tag(“slow”)** | 테스트에 태그 부여. 빌드나 CI 환경에서 특정 태그만 실행 가능. |
- `AssertJ`: 테스트 결과를 직관적으로 검증
- 사용 전: `import org.assertj.core.api.Assertions.*;`

| **함수** | **설명** |
| --- | --- | 
| **assertThat(actual).isEqualTo(expected)** | 값이 같은지 |
| **assertThat(actual).isNotEqualTo(expected)** | 값이 다른지 |
| **assertThat(actual).isTrue / isFalse** | 불리언 확인 |
| **assertThat(list).containsExactly(1, 2, 3)** | 리스트 내용 동일 |
| **assertThat(list).contains(2)** | 특정 요소 포함 여부 |
| **assertThatThrownBy { … }.isInstanceOf(IllegalArgumentException::class.java)** | 예외 타입 검증 |
| **assertThatCode { … }.doesNotThrowAnyException()** | 예외 발생 안함 확인 |
2. `private set`: 프로퍼티의 setter 접근을 제한하는 키워드
    - 값을 외부에서 읽을 수 있으나, 값 변경을 클래스 내부로만 제한하는 키워드
        - 변수를 private로 생성하여 별도의 getter를 생성하는 것은 **보일러플레이트** 라고 생각하여, 이와 같은 키워드를 사용하기로 했다.
    - 예제

        ```kotlin
        var position: Int = 0
            private set
        ```

    - getter 접근을 제한하는 `private get`도 있다.
3. `Enum Class` : 열거형
    - 상수 집합을 하나의 타입으로 정의할 수 있는 클래스
    - 특정 값만 사용하여 오타나 잘못된 값 방지 가능
        - 해당 상수에 메시지, 코드, 동작 등을 연결 가능
    - 예제

        ```kotlin
        enum class ErrorType(val message: String) {
            EMPTY_INPUT("빈 문자열은 입력할 수 없습니다."),
            INVALID_NUMBER("숫자가 아닙니다."),
            NOT_POSITIVE_NUMBER("0 이하의 횟수는 허용되지 않습니다."),
            EMPTY_NAME("공백인 이름은 허용되지 않습니다."),
            INVALID_NAME_LENGTH("이름은 5글자 이하만 허용됩니다.")
        }
        
        ```

4. 객체 생성 팩토리
    - 필요한 객체를 생성하는 책임만 담당
    - 예제

        ```kotlin
        object CarFactory {
            fun createCars(reader: () -> String = { InputView.readNonEmptyLine(InputMessageType.CAR) }): List<Car>
            fun createRound(reader: () -> String = { InputView.readNonEmptyLine(InputMessageType.ROUND) }): Int
        }
        ```

    - SRP를 준수하기 위해, Car 객체에서 생성부만 따로 떼 와서, 객체 생성 책임만 담당하게 함
    - 새로운 생성 로직 추가 시 CarFactory만 수정하면 된다.
5. `Sequnce`: 지연(lazy) 평가 컬렉션을 제공하는 타입
    - 연산이 실제로 필요한 시점에 계산이 이루어짐
    - 지연평가
        - `map`, `filter`, `flatMap`과 같이 연산이 즉시 실행되지 않고, 최종 결과를 요청할 때 계산됨
    - 메모리 효율성이 뛰어나고, 필요 시 연산 체인(최종 연산에서 한 번에 적용) 가능함
    - 예제

        ```kotlin
        fun playAllRounds(moveStrategy: (Car) -> Unit = { it.tryMove() }): Sequence<List<Car>> = sequence {
            repeat(maxRound) {
                yield(playRound(moveStrategy)) // 한 라운드씩 순차적으로 방출
            }
        }
        
        // 사용
        for (round in gameManager.playAllRounds()) {
            round.forEach { OutputView.printCarStatus(it) } // 라운드별 실시간 출력
        }
        ```

        - `yield`를 통해 한 라운드씩 순차적으로 결과값을 방출하게 됨
6. `require`: 조건이 true가 아니면 `IllegalArgumentException`를 발생 시킴
    - 예제

        ```kotlin
        require(condition) { "오류 메시지" }
        ```

7. `class`와 `data class`의 차이


| **특징** | **class** | **data class** |
| --- | --- | --- |
| equals/hashCode | 참조 기반 | 속성 값 기반 |
| toString | 클래스명 + 주소 | 속성 값 출력 |
| copy() | 없음 | 자동 제공 |
| componentN() | 없음 | destructuring 가능 |
| 주 목적 | 기능/행동 중심 | 데이터 보관 중심 |
- 값 자체를 비교하거나, DTO, 모델, 상태 겍체 등 데이터 중심일 때는 `data class` 사용
- 로직, 상태, 상태 변화를 포함한 기능 중심 클래스인 경우 `class` 사용rNames