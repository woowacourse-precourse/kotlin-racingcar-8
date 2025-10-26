# 자동차 경주 (Kotlin) – README

## 1) 목적

간단한 **자동차 경주 게임**을 구현한다. 사용자가 입력한 자동차 이름들과 이동 횟수를 바탕으로, 랜덤 값에 따라 전진하거나 멈추며, 마지막에는 우승자를 출력한다.

---

## 2) 요구사항 요약

* 입력: 자동차 이름(쉼표로 구분, 각 이름 1~5자), 시도 횟수(정수, 1 이상)
* 각 라운드마다 0~9 중 랜덤 값 생성 → 4 이상이면 전진
* 모든 라운드 종료 후 최종 우승자 출력 (동점 가능, 쉼표로 구분)
* 잘못된 입력이면 `IllegalArgumentException` 발생 후 프로그램 종료 (명시적 종료 금지)
* Kotlin 2.2.0 환경, `missionutils.Randoms`, `missionutils.Console` 사용

---

## 3) 패키지 구조 (예시)

```
src
└─ main/kotlin/racingcar
   ├─ Application.kt
   ├─ domain
   │  ├─ Car.kt
   │  ├─ MoveDecider.kt
   │  └─ RandomMoveDecider.kt
   ├─ service
   │  ├─ RaceRound.kt
   │  └─ WinnerFinder.kt
   └─ view
      ├─ InputView.kt
      └─ OutputView.kt

src
└─ test/kotlin/racingcar
   ├─ CarTest.kt
   ├─ RaceRoundTest.kt
   ├─ WinnerFinderTest.kt
   └─ InputValidationTest.kt
```

---

## 4) 기능 구현 목록 (진행 체크용)

* [ ] **입력 처리** : 자동차 이름 입력받기 (`Console.readLine()` 이용)
* [ ] **파싱 로직** : 쉼표 기준 split 및 trim 처리
* [ ] **입력 검증** : 이름 길이(1~5자), 빈 문자열, 공백-only 금지
* [ ] **시도 횟수 입력/검증** : 자연수만 허용, 0 이하/문자 입력 시 예외
* [ ] **난수 생성 로직** : `Randoms.pickNumberInRange(0, 9)` 적용
* [ ] **전진 조건** : 랜덤 값이 4 이상이면 전진
* [ ] **Car 클래스** : 이름, 위치, 이동 로직(`moveIf`) 구현
* [ ] **MoveDecider 인터페이스** : `canMove()` 정의
* [ ] **RandomMoveDecider 구현체** : 랜덤 판단 로직 구현
* [ ] **RaceRound 클래스** : 한 라운드 전체 실행 및 상태 갱신
* [ ] **WinnerFinder 클래스** : 최대 position 기준 우승자 계산
* [ ] **OutputView** : 라운드별 결과 및 최종 우승자 출력
* [ ] **예외 처리** : 잘못된 입력 시 `IllegalArgumentException` 발생
* [ ] **Application.main** : 전체 흐름 연결 및 실행
* [ ] **테스트 코드 작성** : JUnit5 + AssertJ 기반 단위 테스트

> 기능을 완성하면 `[ ]` → `[x]` 로 바꿔 커밋하기.

---

## 5) 입출력 포맷 + 검증 규칙

### 입력 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5
```

### 출력 예시

```
실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

최종 우승자 : pobi, jun
```

### 검증 규칙 상세

* **자동차 이름**

  * 쉼표로 구분된 각 이름을 `trim()` 후 검사
  * 빈 문자열(`""`)이나 공백(`"   "`)은 예외 발생
  * 이름 길이는 1~5자까지만 허용
* **시도 횟수**

  * 숫자가 아닌 입력, 0 이하 값은 예외 발생
* **전진 조건**

  * `Randoms.pickNumberInRange(0, 9)` 결과가 4 이상이면 전진
* **출력 형식**

  * 각 라운드마다 입력 순서대로 `이름 : ---` 출력
  * 전진 안 하면 대시 없음 (`이름 :` 뒤 공백)
* **종료 방식**

  * 잘못된 입력이면 `IllegalArgumentException` 던지고 프로그램 종료 (명시적 `System.exit` 금지)

---

> 💡 **팁:** 테스트에서는 랜덤 대신 `FakeDecider`를 만들어 이동 여부를 고정하면 결과 검증이 쉬움.
