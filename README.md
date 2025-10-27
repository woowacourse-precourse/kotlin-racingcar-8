# kotlin-racingcar-precourse

## 구현할 기능 목록

- [x] [자동차 이름이 중복되는 경우 예외로 처리한다.](#자동차-이름은-중복을-허용하지-않는다)
- [x] [자동차 이름은 1 글자 이상의 문자를 포함해야 한다.](#자동차-이름은-한-글자-이상을-포함해야-한다)
    - 빈 문자열(`""`)은 예외로 처리한다.
- [x] [자동차 이름이 5글자 이하인지 확인한다.](#자동차-이름은-5글자-이하여야-한다)
- [x] [이름은 다양한 특수 문자(`\n`, `\\`)들을 허용한다.](#자동차-이름은-다양한-특수문자를-허용한다)
- [x] [시도 횟수가 음수라면 예외로 처리한다.](#시도-횟수가-음수라면-예외로-처리한다)
- [x] [시도 횟수가 단일 숫자가 아니라면 예외로 처리한다.](#시도-횟수가-단일-숫자가-아니라면-예외로-처리한다)
- [x] [시도 횟수가 최대 데이터 범위를 벗어나는 경우 예외로 처리한다.](#시도-횟수가-최대-데이터-범위를-넘어가는-경우)
- [x] [자동차를 한 칸 전진시킨다.](#요구-조건을-만족하는-자동차들을-한칸-이동시킨다)
    - [자동차의 위치는 0 이상이다](#자동차-위치는-0미만일-수-없다)
- [x] [요구사항을 만족하는 자동차들을 한 칸 전진시킨다.](#요구-조건을-만족하는-자동차들을-한칸-이동시킨다)
- [x] [시도 횟수 만큼 전진 시키거나 멈춘다(nop).](#시도-횟수-만큼-전진-시키거나-멈춘다)
- [x] 요구조건에 맞게 자동차 상태에 맞는 출력을 한다(`pobi: ---`)
- [x] [게임이 종료되었다면 우승자를 출력한다.](#특정-라운드의-우승자를-결정한다)
    - 시도 횟수가 0이라면 곧바로 우승자를 출력한다.
    - 우승자가 단독인 경우는 `최종 우승자: pobi` 형태로 출력한다.
    - 우승자가 여러명인 경우는 쉼표로 구분된 우승자들을 출력한다.

## 결정한 요구 사항

### 1. 자동차 이름의 중복을 허용하지 않는다.

자동차 이름이 중복되면 누가 어느 자동차인지 구분이 어려워 결과 해석이 모호해집니다.
따라서 이름 중복을 허용하지 않고 예외로 처리했습니다.

### 2. 사용자의 입력 시도는 1이상이다.

음수는 예외로 처리했습니다.
0의 경우 한 번도 시도하지 않는다는 의미로 유효하다고 판단했습니다.(바로 우승자 출력)

## 테스트 코드

### 자동차 이름은 한 글자 이상을 포함해야 한다

```kotlin
@Test
fun `자동차 이름은 한 글자 이상을 포함해야 한다`() {
    assertSimpleTest {
        assertThrows<IllegalArgumentException> { Car.withStartPosition("") }
    }
}
```

`Car.withStartPosition`을 활용해 `Car` 객체를 생성할 때 빈 이름인 경우 예외를 던지도록 했습니다.

### 자동차 이름은 5글자 이하여야 한다

```kotlin
@Test
fun `자동차 이름은 5글자 이하여야 한다`() {
    assertSimpleTest {
        assertThrows<IllegalArgumentException> { Car.withStartPosition("123456") }
    }
}
```

`Car`을 생성될 때 5글자를 초과하는 경우 예외를 던지도록 했습니다.

### 자동차 이름은 중복을 허용하지 않는다

```kotlin
@Test
fun `자동차 이름은 중복을 허용하지 않는다`() {
    assertSimpleTest {
        val names = listOf("A", "A")
        assertThrows<IllegalArgumentException> { Round.startWith(names) }
    }
}
```

이름에 중복이 발생하는 경우 `Round`를 생성할 때 예외를 던지도록 했습니다.

### 자동차 이름은 다양한 특수문자를 허용한다

```kotlin
@ParameterizedTest
@ValueSource(strings = ["\n", "\t", " ", "''", "\"", "\\", "``", "wo\ni!"])
fun `자동차 이름은 다양한 특수문자를 허용한다`(specialName: String) {
    assertSimpleTest {
        assertDoesNotThrow { Car.withStartPosition(specialName) }
    }
}
```

자동차의 생성에서 여러 특수문자 및 공백은 허용됩니다.

### 자동차 위치는 0미만일 수 없다

```kotlin
@Test
fun `자동차 위치는 0미만일 수 없다`() {
    assertSimpleTest {
        assertThrows<IllegalArgumentException> { Car("pobi", -1) }
    }
}
```

자동차의 위치가 0 미만인 경우 생성할 때 예외를 던집니다.

### 요구 조건을 만족하는 자동차들을 한칸 이동시킨다

```kotlin
@ParameterizedTest
@MethodSource("movingConditionsAndExpectedCars")
fun `요구 조건을 만족하는 자동차들을 한칸 이동시킨다`(startRound: Round, randomNumbers: List<Int>, nextRound: Round) {
    assertSimpleTest {
        assertThat(startRound.tryMoveForward(randomNumbers)).isEqualTo(nextRound)
    }
}

@JvmStatic
fun movingConditionsAndExpectedCars(): List<Arguments> {
    return listOf(
        Arguments.of(
            Round(listOf(Car("pobi", 0), Car("jun", 0))),
            listOf(0, 1),
            Round(listOf(Car("pobi", 0), Car("jun", 0))),
        ),
        Arguments.of(
            Round(listOf(Car("pobi", 0), Car("jun", 0))),
            listOf(2, 3),
            Round(listOf(Car("pobi", 0), Car("jun", 0))),
        ),
        Arguments.of(
            Round(listOf(Car("pobi", 0), Car("jun", 0))),
            listOf(4, 5),
            Round(listOf(Car("pobi", 1), Car("jun", 1))),
        ),
        Arguments.of(
            Round(listOf(Car("pobi", 0), Car("jun", 0))),
            listOf(6, 7),
            Round(listOf(Car("pobi", 1), Car("jun", 1))),
        ),
        Arguments.of(
            Round(listOf(Car("pobi", 0), Car("jun", 0))),
            listOf(8, 9),
            Round(listOf(Car("pobi", 1), Car("jun", 1))),
        )
    )
}
```

`Round.tryMoveForward`는 랜덤 값들의 리스트를 받아 움직일 지 말지를 결정 후 다음 `Round`를 반환합니다.

### 시도 횟수 만큼 전진 시키거나 멈춘다

```kotlin
@ParameterizedTest
@CsvSource("0,1", "1,2", "2,3")
fun `시도 횟수 만큼 전진 시키거나 멈춘다`(userInput: Int, roundSize: Int) {
    assertSimpleTest {
        val cars = Round(listOf(Car.withStartPosition("pobi"), Car.withStartPosition("jun")))
        val racingGame = Racing.start(cars, attempt = Attempt(userInput))
        assertThat(racingGame.totalRounds()).isEqualTo(roundSize)
    }
}
```

시도 횟수 만큼 `racingGame`은 `round`를 만듭니다. 0부터 시작되기에 n개의 시도면 n + 1개의 `Round`를 가집니다.

### 특정 라운드의 우승자를 결정한다

```kotlin
@ParameterizedTest
@MethodSource("roundAndWinner")
fun `특정 라운드의 우승자를 결정한다`(finalRound: Round, winners: List<Car>) {
    assertSimpleTest {
        assertThat(finalRound.getWinners()).isEqualTo(winners)
    }
}

@JvmStatic
fun roundAndWinner(): List<Arguments> {
    return listOf(
        Arguments.of(
            Round(listOf(Car("pobi", 1), Car("jun", 2), Car("woni", 3))),
            listOf(Car("woni", 3))
        ),
        Arguments.of(
            Round(listOf(Car("pobi", 3), Car("jun", 2), Car("woni", 3))),
            listOf(Car("pobi", 3), Car("woni", 3))
        )
    )
}
```

`getWInners()`를 통해 특정 라운드에서 가장 멀리 간 자동차를 `List<Car>`로 반환합니다.

### 시도 횟수가 음수라면 예외로 처리한다

```kotlin
@Test
fun `시도 횟수가 음수라면 예외로 처리한다`() {
    assertSimpleTest {
        assertThrows<IllegalArgumentException> { Attempt(-1) }
    }
}
```

시도 횟수가 음수인 경우 `Attempt` 생성에서 예외를 반환합니다.

### 시도 횟수가 단일 숫자가 아니라면 예외로 처리한다

```kotlin
@ParameterizedTest
@ValueSource(strings = ["123,", "1 ", " 2 ", " ", "abc"])
fun `시도 횟수가 단일 숫자가 아니라면 예외로 처리한다`(userInput: String) {
    assertSimpleTest {
        assertThrows<IllegalArgumentException> { Attempt(userInput.toInt()) }
    }
}
```

시도 횟수가 단일 숫자가 아니라면(소수 혹은 문자가 포함되는 경우) `toInt`에서 예외가 발생합니다.

### 시도 횟수가 최대 데이터 범위를 넘어가는 경우

```kotlin
@Test
fun `시도 횟수가 최대 데이터 범위를 넘어가는 경우`() {
    val maxValue = ((Int.MAX_VALUE).toLong() + 1).toString()
    assertSimpleTest {
        assertThrows<IllegalArgumentException> { Attempt(maxValue.toInt()) }
    }
}
```

`Int` 범위를 넘어가는 것에 대해 `toInt`를 수행하면 예외를 반환합니다.

### pobi와 jun이 승리하는 5턴 전체 게임 플레이

```kotlin
@ParameterizedTest
@MethodSource("slowMotionRacing")
fun `pobi와 jun이 승리하는 5턴 전체 게임 플레이`(currentRound: Round, randomNumbers: List<Int>, winner: List<Car>) {
    assertSimpleTest {
        assertThat(currentRound.tryMoveForward(randomNumbers).getWinners()).isEqualTo(winner)
    }
}

@JvmStatic
private fun slowMotionRacing(): List<Arguments> {
    return listOf(
        Arguments.of(
            Round(listOf(Car("pobi", 0), Car("jun", 0), Car("woni", 0))),
            listOf(4, 3, 4),
            listOf(Car("pobi", 1), Car("woni", 1))
        ),
        Arguments.of(
            Round(listOf(Car("pobi", 1), Car("jun", 0), Car("woni", 1))),
            listOf(4, 4, 4),
            listOf(Car("pobi", 2), Car("woni", 2))
        ),
        Arguments.of(
            Round(listOf(Car("pobi", 2), Car("jun", 1), Car("woni", 2))),
            listOf(4, 4, 4),
            listOf(Car("pobi", 3), Car("woni", 3))
        ),
        Arguments.of(
            Round(listOf(Car("pobi", 3), Car("jun", 2), Car("woni", 3))),
            listOf(4, 3, 4),
            listOf(Car("pobi", 4), Car("woni", 4))
        ),
        Arguments.of(
            Round(listOf(Car("pobi", 4), Car("jun", 3), Car("woni", 4))),
            listOf(4, 4, 4),
            listOf(Car("pobi", 5), Car("woni", 5))
        ),
    )
}
```

과제에서 나온 pobi와 woni가 승리하는 예시입니다.
`Racing`은 단순히 `Round`를 순회하며 적절한 `Round`의 행위를 수행하는 역할을 하기에 직접 테스트하지 않았습니다.
대신 `Racing`을 구성하는 모든 `Round`에 대한 테스트를 진행했습니다.
    
