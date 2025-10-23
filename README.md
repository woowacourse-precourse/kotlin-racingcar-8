# [2주차] 자동차 경주 🚗
초간단 자동차 경주 게임을 구현한다.

## 기능 목록 📝
#### 1. 애플리케이션을 실행하면 안내 문구를 출력하고, 자동차 이름과 시도할 횟수를 입력받는다.
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5
```
#### 2. 쉼표(,)를 기준으로, 자동차 이름을 분리한다.
#### 3. 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진하고 4 미만일 경우 멈춘다.
#### 4. 실행 결과 첫 출력시 '실행 결과' 문구를 출력하고, 한 횟수가 끝날 때마다 결과를 출력한다.
```
실행 결과
pobi : -
woni :
jun : -

```
#### 5. 게임을 완료한 후 누가 우승했는지 출력하고, 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
```
최종 우승자 : pobi, jun
```
#### 6. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료된다.
- 자동차 이름이 5자를 초과인 경우
- 쉼표로 구분한 각 이름이 비어있거나 공백일 경우 (예: pobi,,jun)
- 시도할 횟수가 1 미만의 숫자인 경우 (또는 숫자가 아닌 경우)

#### 7. 기능 목록이 정상 작동하는지 테스트 코드로 확인한다.


## 설계 🧩
#### main
```
racingcar
├── controller
│   └── RaceController.kt
│
├── domain
│   ├── Car.kt
│   └── Race.kt
│
├── view
│   ├── InputView.kt
│   └── ResultView.kt
│
├── util
│   ├── InputParser.kt
│   ├── InputValidator.kt
│   └── RandomUtils.kt
│
└── Application.kt (main 함수)
```
#### test
```
racingcar
├── controller
│   └── RaceControllerTest.kt
│
├── domain
│   ├── CarTest.kt
│   └── RaceTest.kt
│
└── util
    ├── InputParserTest.kt
    └── InputValidatorTest.kt
```
