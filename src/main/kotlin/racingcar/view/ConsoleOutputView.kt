package racingcar.view

import racingcar.domain.game.Car
import racingcar.view.CliText.PROMPT_CAR_NAMES
import racingcar.view.CliText.PROMPT_PLAY_RESULT
import racingcar.view.CliText.PROMPT_ROUND_COUNT
import racingcar.view.CliText.PROMPT_WINNER

class ConsoleOutputView : OutputView {
    override fun printCarNamesPrompt() {
        println(PROMPT_CAR_NAMES)
    }

    override fun printAttemptCountPrompt() {
        println(PROMPT_ROUND_COUNT)
    }

    override fun printPlayerRoundResult(cars: List<Car>) {
        cars.stream().forEach({ car ->
            println(car)
        })
    }

    override fun printBlankLine() {
        println();

    }

    override fun printRoundResultPrompt() {
        println()
        println(PROMPT_PLAY_RESULT);
    }

    override fun printWinner(winners: List<String>?) {
        var winnersResult = ""
        if (winners != null) {
            for (s in winners) {
                winnersResult += "$s, "
            }
        }

        println(PROMPT_WINNER + " : " + winnersResult.substring(0, winnersResult.length - 2))
    }


}



