# kotlin-racingcar-precourse
### 자동차 경주 게임

- [ ] 각 자동차에 이름을 부여, 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
    - camp.nextstep.edu.missionutils.Console의 readLine()을 활용
    - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능

- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력
    - 주어진 횟수 동안 n대의 자동차는 전진 또는 정지
        - 0에서 9 사이에서 무작위 값이 4 이상이면 전진
    - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
        -     Randoms.pickNumberInRange(0, 9)

- [ ] 경주가 완료되면 우승자를 출력
    - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분

#### 추가 요구사항
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
    - 자동차 이름이 5자를 초과하는 경우
    - 자동차 이름이 중복되는 경우
    - 시도 횟수가 숫자가 아닌 경우
    - 시도 횟수가 음수인 경우

- [ ] indent depth를 3이 넘지 않도록 구현

- [ ] 함수가 단일책임
    - 전략패턴으로 구현