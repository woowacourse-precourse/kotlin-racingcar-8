package racingcar

fun main() {
    // 차 이름, 시도 횟수 입력
    val inputName = InputView.inputCarNames()
    val inputTryCount = InputView.inputTryCount()

    // 입력 받은 정보가 올바른지 검증
    val carNames = InputValidator.validateCarNames(inputName)
    val tryNumber = InputValidator.validateTryCount(inputTryCount)

    // 자동차이름과 이동상태를 매핑
    val cars = carNames.map { Car(it) }

    // 자동차 객체 리스트 생성
    val game = RacingGame(cars, MoveRule())

    println("\n실행 결과")
    //입력 횟수만큼 게임 반복 실행
    repeat(tryNumber) {
        game.play()
        OutputResult.printCars(cars)
        println()
    }

    // 최종 우승자 출력
    val winners = game.resultWinner()
    OutputResult.printWinners(winners)


}


