package racingcar.view

import racingcar.constant.OutputMessage

object OutputView {
    private const val MOVE_SYMBOL = "-"
    private const val WINNER_DELIMITER = ", "

    fun displayTitle() {
        println()
        println(OutputMessage.TITLE.text)
    }

    fun displayRoundResult(result: Map<String, Int>) {
        result.forEach { (name, score) ->
            val formattedScore = MOVE_SYMBOL.repeat(score)
            println(OutputMessage.ROUND_RESULT.format(name, formattedScore))
        }
        println()
    }

    fun displayWinners(winners: List<String>) {
        println(OutputMessage.WINNERS.format(winners.joinToString(WINNER_DELIMITER)))
    }
}