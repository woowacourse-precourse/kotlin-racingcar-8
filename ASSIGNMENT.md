# kotlin-racingcar-precourse

## 테스트 실행
```text
.\gradlew.bat clean test
```

## 과제 진행 요구 사항
- [자동차 경주](https://github.com/woowacourse-precourse/kotlin-racingcar-8) 저장소를 포크하고 클론으로 시작
- 기능 구현 전 `README.md`에 정리한 기능 목록 단위 추가
- [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고하여 커밋 메시지 작성
  ```text
  <type>(<scope>): <subject>
  <BLANK LINE>
  <body>
  <BLANK LINE>
  <footer>
  ```
    - Allowed `<type>`
        - feat
        - fix
        - docs
        - style
        - refactor
        - test
        - chore
    - Allowed `<scope>`
        - 커밋 변경 범위
        - EX) \$location, \$browser, \$compile, $rootScope, ngHref, ngClick, ngView
    - `<subject>` text
        - 현재 시제 사용한 변경 사항 작성 (과거형, 미래형 금지)
        - 첫 글자 대문자 사용 금지
        - 끝에 점(.) 작성 X
    - Message body
        - 변화에 대한 동기 등 작성
        - 여기서도 과거형, 미래형 금지
    - Message Footer
        - 모든 호환이 깨지는 변경 사항 명시
        - 변경 내용의 설명
        - 변경의 이유
        - 이전 코드에서 새 버전으로 옮길 때 필요한 안내

## 기능 요구 사항
> 초간단 자동차 경주 게임을 구현
- 주어진 횟수 동안 n대의 자동차는 `전진` 또는 `정지`할 수 있음
- 각 자동차 이름 부여. 전진 시 자동차를 출력할 때 자동차 이름을 같이 출력
- 자동차 이름은 쉼표`,`를 기준으로 구분하며 이름은 5자 이하만 가능
- 사용자는 몇 번의 이동을 할 것인지 입력할 수 있어야 함
- 전진 조건은 0~9의 무작위 값에서 4 이상인 경우
- 자동차 경주 게임 완료 후 우승자를 출력 (단, 우승자는 1명 이상일 수 있음)
- 우승자가 여러 명일 경우 쉼표`,`를 이용하여 구분
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 종료

## 입출력 요구 사항
### 입력
- 경주할 자동차 이름(이름은 쉼표`,` 기준으로 구분)
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

## 프로그래밍 요구 사항 1
- 실행 환경 : Kotlin 2.2.0
- Kotlin 코드로만 구현
- 프로그램 실행의 시작점은 Application의 main()
- 변경 금지
    - build.gradle.kts
- 요구 사항에 달리 명시하지 않는 한 파일, 패키지 등 이름 변경 또는 이동 금지
- 외부 라이브러리 사용 금지
- 프로그램 종료 시 호출 금지
    - System.exit()
    - exitProcess()
- 코드 컨벤션 준수 : [Kotlin Style Guide](https://kotlinlang.org/docs/coding-conventions.html)

## 프로그래밍 요구 사항 2
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현 (2까지만 허용)
  - EX) while문 안에 if문이 있으면 indent는 2
- 함수가 한 가지 일만 하도록 최대한 작게 작성
- JUnit와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는 지 테스트 코드 확인
  - 테스트 도구는 아래 문서를 참고하여 학습
    - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
    - [AssertJ User Guide](https://assertj.github.io/doc)
    - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
    - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

## 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 사용하여 구현
  - Random 값 추출은 `pickNumberInRange()`를 사용
  - 사용자 입력은 `readLine()`을 활용
### 사용 예시
- 0에서 9까지 정수 중 1개 정수 반환
```text
Randoms.pickNumberInRange(0, 9)
```