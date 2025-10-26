# 자동차 경주

## 프로그래밍 요구사항

- Kotlin 2.2.0에서 실행 가능해야 한다.
- Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle.kts` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()` 또는 `exitProcess()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 코틀린 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Kotlin Style Guide](https://kotlinlang.org/docs/coding-conventions.html)를 원칙으로 한다.
- `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 프로그래밍 요구사항 2

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
---

## 구현 기능 목록

### 1. 사용자 입력
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - 이름이 5자 이상인 경우 `IllegalArgumentException` 발생
  - 빈 문자열인 경우 `IllegalArgumentException` 발생

### 2. 횟수 입력
- [x] 몇 번의 이동을 할 것인지를 입력
- [x] 형식이 올바르지 않은 경우 `IllegalArgumentException` 발생
  - 양의 정수가 아닌경우 `IllegalArgumentException` 발생
  - 정수로 나타낼 수 없는 경우 `IllegalArgumentException` 발생

### 2. 자동차 경주
- [x] 자동차의 이름과 현재 위치를 나타내는 객체 생성
- [x] 0 ~ 9 무작위 값 추출
  - 무작위 값이 4 이상이라면 전진
- [x] 게임 횟수에 따른 반복 및 전진

### 3. 출력
- [ ] 우승자 판별 및 결과 출력
  - 한명이라면 단일 출력
  - 여러명이라면 ,를 이용하여 구분

---

## 입출력 요구 사항

**입력**
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
pobi,woni,jun
```
- 시도할 횟수
```
5
```
**출력**
- 차수별 실행 결과
```
pobi : --
woni : ----
jun : ---
```
**실행 결과 예시**
- 단독 우승자 안내 문구
```
최종 우승자 : pobi
```
- 공동 우승자 안내 문구
```
최종 우승자 : pobi, jun
```