package racingcar.view

import racingcar.constant.OutputMessage

object OutputView {

    fun displayTitle() {
        println(OutputMessage.TITLE.text)
    }

    fun displayRoundResult(result: Map<String, Int>) {
        result.forEach { (name, score) ->
            val formattedScore = "-".repeat(score)
            println(OutputMessage.ROUND_RESULT.format(name, formattedScore))
        }
    }

    fun displayWinners(winners: List<String>) {
        println(OutputMessage.WINNERS.format(winners.joinToString(", ")))
    }
}