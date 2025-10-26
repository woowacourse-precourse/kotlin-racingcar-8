# kotlin-racingcar-precourse

## 기능 요구 사항
1. 이름이 5글자 이하인 n개의 자동차 입력
   - 자동차 이름은 쉼표로 구분
   - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 문구 출력
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
   - 입력된 자동차는 리스트에 저장
2. 이동 횟수 입력
   - `시도할 횟수는 몇 회인가요?` 문구 출력
3. 전진조건
   - 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진
   - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
   - 각각의 자동차마다 이동 횟수별로 Random 값 추출해서 조건에 성립하면 전진
   - 차수별 실행결과 출력
     - 실행 결과
     ```markdown
       pobi : -
       woni :
       jun : -
     
4. 우승자
   - 자동차 경주 게임 완료한 후 누가 우승했는지 알려준다.
     - 단독 우승자 안내 문구: `최종 우승자 : pobi`
   - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
     - 공동 우승자 안내 문구: `최종 우승자 : pobi, jun`
5. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생
    - 자동차 이름이 5글자가 초과된 경우