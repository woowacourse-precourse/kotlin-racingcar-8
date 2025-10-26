package racingcar.view

import racingcar.domain.Car

object OutputView {
    private const val POSITION_MARKER = "-"
    private const val WINNER_DELIMITER = ", "

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${POSITION_MARKER.repeat(car.getPosition())}")
        }
        println()
    }

    fun printExecutionResult() {
        println("\n실행 결과")
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(WINNER_DELIMITER)}")
    }
}
