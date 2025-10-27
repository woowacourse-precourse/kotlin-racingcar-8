## - 구현할 기능 목록
  - [ ] 시작시 출력을 담당하는 기능
  - [ ] 결과 출력을 담당하는 기능
  - [ ] 입력에 대하여 처리하는 기능
  - [ ] 각 회차를 진행하는 기능
  - [ ] 0~9사이의 값중 4이상일 때 전진하는 기능
  - [ ] 누가 우승했는지 계산하는 기능
  - [ ] 자동차 이름과 이동량에 대해서 관리하는 기능

2주차 과제는 [자동차 경주]를 구현하는 과제  
MVC 패턴을 적용하여 구현하였다.   

`Application`에서는 RaceController를 생성해 startRace()를 실행시켜줌

`view`에는 `InputView`와 `OutputView`가 있는데 각각 `Input`, `Output`인터페이스를 상속 받고있다.  
원래는 단순 `Object`로 선언하였었는데, 테스트를 작성하다보니 인터페이스를 만드는게 좋아보이기에 수정하였다  

`model`에는 `InputParser`, `NumberGenerator`인터페이스, `RandomNumberGenerator`, `CarManager`가 존재한다.  
기존에는 `CarManager`에 `Console.pickNumberInRange()`를 바로 사용하였었지만, 테스트를 할때 이를 제어할 수 없어 따로 인터페이스와 구현체로 분리하여 사용하 였다.  

`InputParser`는 들어온 입력에 대해서 파싱하고 유효성 검사를 담당하고 있다.  
`CarManager`는 필드로 map을 가지고 있어 차의 이름과 위치를 저장하고, 이동시키고 결과를 계산한다

`controller`에 `RaceController`는 `startRace()`메소드로 전체 과정을 진행한다.  


그외에도 테스트 코드도 작성하였는데, 난수 생성을 제어하기 위해서 `model`에는 `FixedNumberGenerator`를 만들었고,  
`controller`에서 `RaceController`를 테스트하기 위해서 `FakeInput`과 `FakeOutput`을 만들어서 테스트가 독립적으로 동작할 수 있도록 단위 테스트를 완성하였다.