package racingcar

object OutputView {
    private const val RESULT_HEADER = "\n실행 결과"
    private const val POSITION_SYMBOL = "-"
    private const val NAME_POSITION_SEPARATOR = " : "
    private const val WINNER_PREFIX = "최종 우승자 : "
    private const val WINNER_DELIMITER = ", "

    fun printResultHeader() {
        println(RESULT_HEADER)
    }

    fun printRaceRound(cars: List<Car>) {
        cars.forEach { car ->
            printCarStatus(car)
        }
        println()
    }

    private fun printCarStatus(car: Car) {
        val position = POSITION_SYMBOL.repeat(car.getPosition())
        println("${car.name}$NAME_POSITION_SEPARATOR$position")
    }

    fun printWinners(winners: List<String>) {
        println("$WINNER_PREFIX${winners.joinToString(WINNER_DELIMITER)}")
    }
}
