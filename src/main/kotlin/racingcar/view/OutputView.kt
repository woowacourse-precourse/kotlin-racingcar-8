package racingcar.view

import racingcar.domain.Car

object OutputView {
    private const val RESULT_HEADER = "실행 결과"
    private const val WINNER_PREFIX = "최종 우승자 : "
    private const val CAR_STATUS_FORMAT = " : "
    private const val DASH = "-"
    private const val WINNER_DELIMITER = ", "

    fun printResultHeader() {
        println()
        println(RESULT_HEADER)
    }

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            printSingleCarStatus(car)
        }
        println() // 자동차 출력 후 한 줄
        println() // 라운드 간 빈 줄
    }

    private fun printSingleCarStatus(car: Car) {
        val dashes = createDashes(car.getPosition())
        println("${car.getName()}$CAR_STATUS_FORMAT$dashes")
    }

    fun createDashes(position: Int): String {
        return DASH.repeat(position)
    }

    fun printWinners(winners: List<String>) {
        val winnersText = winners.joinToString(WINNER_DELIMITER)
        println("$WINNER_PREFIX$winnersText")
    }
}