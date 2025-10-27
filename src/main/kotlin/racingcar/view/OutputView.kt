package racingcar.view

object OutputView {
    private const val RESULT_HEADER = "\n실행 결과"
    private const val POSITION_SYMBOL = "-"
    private const val NAME_POSITION_DELIMITER = " : "
    private const val WINNER_PREFIX = "최종 우승자 : "
    private const val WINNER_DELIMITER = ", "

    fun printResultHeader() {
        println(RESULT_HEADER)
    }

    fun printRoundResult(carStatus: List<Pair<String, Int>>) {
        carStatus.forEach { (name, position) ->
            println("$name$NAME_POSITION_DELIMITER${POSITION_SYMBOL.repeat(position)}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("$WINNER_PREFIX${winners.joinToString(WINNER_DELIMITER)}")
    }
}