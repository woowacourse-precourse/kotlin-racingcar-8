# kotlin-racingcar-precourse

[1. 입력 기능](#입력-기능)

[2. 출력 기능](#출력-기능)

[3. Model](#model)

[4. View](#view)

[5. Controller](#controller)

## 기능 요구 사항

초간단 자동차 경주 게임 구현

### 입력 기능

자동차 이름 입력 기능

- [ ] 쉼표를 기준으로 자동차 이름 파싱
- [ ] `trim()`을 통해 자동차 이름 앞, 뒤 공백 문자 처리
    - 유효성 검증
    - [ ] 아무런 입력이 없거나 `\n` 개행 문자인 경우 예외 처리

자동차 이동 횟수 입력 기능

- [ ] 자동차 이동 횟수 입력
    - 유효성 검증
    - [ ] 양의 정수가 아닌 경우 예외 처리

### 출력 기능

- [ ] 현재 자동차 위치 출력 기능
    ```text
    // 예시
    pobi : --
    woni : ----
    jun : ---
    ```

- [ ] 우승자 안내 출력 기능
    ```text
    // 단독 우승
    최종 우승자 : pobi
  
    // 공동 우승
    최종 우승자 : pobi, jun
    ```

### Model

- [ ] `Car`: 자동차 정보를 저장하는 객체
    - [x] `name`: Car의 이름
        - [ ] 이름이 5자 이하가 아니라면 예외 처리
        - [ ] 중복된 자동차 이름이 있는 경우 예외 처리
    - [x] `position`: 현재 Car의 위치
        - 초기 위치는 0
    - [x] `move()`: Car의 현재 위치를 변경시키는 메서드
        - `camp.nextstep.edu.missionutils`의 `Randoms` API를 사용해서 4이상일 경우 전진
- [ ] `Cars`: 자동차 경주에 참여하고 있는 Car의 이름을 저장하는 HashMap
- [ ] `playRace()`: 자동차 경주를 한번 실행하는 함수
- [ ] `getWinPlayers()`: 자동차 경주의 우승자를 구하는 함수

### View

- [x] `getCarNameInput()`: 자동차 이름을 입력 처리 메서드
    - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

- [x] `getCarRaceCountInput()`: 자동차 경주를 반복할 횟수 입력 처리 메서드
    - `시도할 횟수는 몇 회인가요?`
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

- [ ] `printCarRaceResultTitle()`: `실행 결과` 출력 메서드

- [ ] `printCarRaceCurrentResult()`: 현재 자동차 경주 현황을 출력하는 메서드
    ```text
    pobi : -
    woni : 
    jun : -
    ```

- [ ] `printCarRaceWinnerResult()`: 자동차 경주 우승자 출력하는 메서드
    - [ ] 위치가 같은 우승자가 여러 명이라면 `,`를 이용하여 구분
    - `최종 우승자 : carName1, carName2, ...`

### Controller

- [ ] `run()`: Service의 로직 처리, View에 결과 전달