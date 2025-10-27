package racingcar.adaptors.view

import racingcar.domain.game.RacingCar
import racingcar.adaptors.view.CliText.PROMPT_CAR_NAMES
import racingcar.adaptors.view.CliText.PROMPT_PLAY_RESULT
import racingcar.adaptors.view.CliText.PROMPT_ROUND_COUNT
import racingcar.adaptors.view.CliText.PROMPT_WINNER
import racingcar.domain.game.Car

class ConsoleOutputView : OutputView {
    override fun printCarNamesPrompt() {
        println(PROMPT_CAR_NAMES)
    }

    override fun printAttemptCountPrompt() {
        println(PROMPT_ROUND_COUNT)
    }

    override fun printPlayerRoundResult(racingCars: Collection<Car>) {
        racingCars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
    }

    override fun printBlankLine() {
        println();

    }

    override fun printRoundResultPrompt() {
        println()
        println(PROMPT_PLAY_RESULT);
    }

    override fun printWinner(winners: Collection<String>) {
        var winnersResult = ""

        for (s in winners) {
            winnersResult += "$s, "
        }
        println(PROMPT_WINNER + " : " + winnersResult.substring(0, winnersResult.length - 2))
    }
}



