# kotlin-racingcar-precourse
***
## 목적
- 초간단 자동차 경주 게임을 구현
***
## 기능 구분
- 경주할 자동차의 이름을 입력
  - 여러 대를 입력할 경우 쉼표(,)로 구분 받음
- 자동차를 움직일 횟수를 입력
- 자동차는 전진 또는 멈출 수 있음
  - 전진하는 조건은 0~9 중에 무작위로 받아오는 수가 4 이상일 경우
- 자동차 경주가 끝난 후에 결과 출력 시 우승한 자동차의 이름을 출력
  - 자동차는 한 대 이상일 수 있음
  - 여러 대일 경우 쉼표(,)로 구분하여 출력함
***
## 예외 상황
- 자동차의 이름 5자 초과인 경우
- 자동차 이름 입력에 아무것도 적지 않았을 경우
- 구분자가 쉼표(,)가 아닌 경우
- 움직일 횟수를 입력받을 때 값이 양의 정수가 아닌 경우
***
## 입출력 예시
~~~
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
~~~
## 프로젝트 구조
### Main
- model
  - Car.kt : 이름과 움직임의 데이터를 갖는 자동차 클래스
- controller
  - InputController : 이름과 움직임의 입력의 예외처리를 하며 원하는 형태로 반환해주는 클래스
  - CarController : 원하는 횟수만큼 전진 또는 정지하며 자동차들을 관리하는 클래스
  - RacingCarController : InputController, CarController와 View를 연결시켜주는 클래스
- view
  - View.kt : Console에 데이터를 출력해주는 View 클래스
### Test
- model
  - CarTest.kt : 자동차가 전진과 정지를 잘 하는가에 대한 테스트 코드
- controller
  - InputControllerTest.kt : 입력 값에 대해 제대로 반환하는가, 예외처리를 잘 하는가에 대한 테스트 코드
  - CarControllerTest.kt : 한 대 이상의 자동차의 움직임을 잘 받으며 가장 많이 움직임을 가지는 자동차의 이름을 반환하는가에 대한 테스트 코드
  - RacingCarControllerTest.kt : 전체적인 Controller와 View가 연결되어 원하는 결과를 출력하는가에 대한 테스트 코드