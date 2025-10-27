package racingcar.view.domain

import racingcar.view.OutputMessages

object ResultView {
    fun consoleLine() {
        println(OutputMessages.REUSLT_LINE)
    }

    fun consoleProgress(names: List<String>, history: List<List<Int>>) {
        history.forEach { positions ->
            names.forEachIndexed { index, name ->
                println("$name${OutputMessages.COLON}${OutputMessages.HYPEHON.repeat(positions[index])}")
            }
            println()
        }
    }

    fun consoleWinner(winners: String) {
        println(OutputMessages.WINNER_GUIDE + winners)
    }
}