package racingcar.view

import racingcar.domain.Car

object OutputView {
    fun printCarNamesPrompt() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    fun printRaceCountPrompt() = println("시도할 횟수는 몇 회인가요?")

    fun printStartMessage() = println("\n실행 결과")

    fun printRoundCars(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${car.getPositionString()}")
        }
    }

    fun printBlankLine() = println()

    fun printWinners(winnerNames: List<String>) = println("최종 우승자 : ${winnerNames.joinToString(", ")}")
}
