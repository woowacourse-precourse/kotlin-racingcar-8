# kotlin-racingcar-precourse
## 기능 요구 사항 리스트

### 입력

자동차 이름 입력

- 쉼표로 구분
- 5자 이하만 가능

시도할 횟수 입력

- 정수로 입력

### 처리

0에서 9까지 무작위 값을 구한 후 4 이상일 경우만 전진

4 미만이면 정지 후 다음 턴

우승자는 한 명 이상 가능

우승자가 나올때 까지 진행

### 출력

차수별 실행 결과 출력

-를 이용하여 진척도 나타내기

최종 우승자 출력

- 공동인 경우 , 쉼표를 이용하여 구분

### 예외발생

- 사용자의 입력값이 잘못될 경우 IllegalArgumentException 예외 발생 후 종료
    1. 이름이 5자 초과일 경우
    2. 이름을 구분 지을때 쉼표가 아닌 다른 문자가 적힐 경우
    3. 몇 번 이동할지 정할때 숫자가 0이하일 경우
    4. 아무런 입력이 없을 때
    5. 이름이 알파벳이 아닐때

## 작성한 코드의 사용 이유

### 1. 자동차 이름 입력 및 저장

```kotlin
fun carNameSetting() {
    val carNames = processCarNaming() // input().split(",")
    validateNamesLength(carNames)
    validateNamesType(carNames)

    for (carName in carNames) {
        cars.add(carName)
        carRunStatus[carName] = 0
    }
}
```

- `validate`~ 함수들은 자동차 이름을 설정할 때 예외처리를 위함

### 2. 자동차 이름 유효성 검사

```kotlin
fun validateNamesLength(names: List<String>) {
    if (!names.all { it.length <= 5 }) {
        throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
    }
    if (!names.all { it.isNotEmpty() }) {
        throw IllegalArgumentException("이름을 비워둘 수 없습니다.")
    }
}
```

- `names.all` 코틀린의 컬렉션 함수 `all`을 사용한 이유는 모든 요소가 조건`it.length <= 5`을 만족하는지 검사
- `it.isNotEmpty()`는 비어있는 문자열이 있는지 검사하기 위해 사용

### 3. 시도 횟수 입력 및 검증

```kotlin
fun timeSetting() {
    val inputTime = input()
    movingTime = inputTime.toIntOrNull()
        ?: throw IllegalArgumentException("숫자만 가능합니다.")
    if (movingTime <= 0) {
        throw IllegalArgumentException("횟수는 1 이상이어야 합니다.")
    }
}
```

- `inputTime.toIntOrNull()`  `toIntOrNull()`은 숫자가 아니면 null 을 반환하여 엘비스 연산자와 함께 예외를 발생
- `?:` 엘비스 연산자. `toIntOrNull()`이 null 을 반환할 경우 `throw` 구문이 실행되어  예외를 발생

### 4. 핵심 레이싱 로직 (전진 및 상태 누적)

```kotlin
fun judgeFourMoreRole(car: String) {
    val randomNumber = pickRandomNumber()
    if (randomNumber >= 4) {
        val currentStatus = carRunStatus.getOrDefault(car, 0)
        carRunStatus[car] = currentStatus + 1
    }
}

```

- `getOrDefault` 는 맵에 Key가 없더라도 null 대신 기본값 0을 반환 받음
- `carRunStatus[car] = currentStatus + 1` 자동차의 bar 전진 상태가 누적

### 5. 최종 우승자 판별

```kotlin
fun winner() {
    val maxBar = carRunStatus.values.maxOrNull() ?: 0
    val winners = carRunStatus
        .filter { it.value == maxBar }
        .keys

    println("최종 우승자 : ${winners.joinToString(", ")}")
}

```

- `maxOrNull()` 맵이 비어있을 경우 `null`을 반환할 수 있어`?: 0`으로 처리
- `.filter { it.value == maxBar }filter`를 사용해 맵의 모든 항목 중 최대거리와 같은 경우 반환
