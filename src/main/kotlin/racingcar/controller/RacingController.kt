package racingcar.controller

import racingcar.model.RacingGame
import racingcar.view.ConsoleView
import racingcar.view.View

class RacingController(
    private val view: View = ConsoleView(),
    private val racingGame: RacingGame = RacingGame(),
) {
    fun run() {
        val carNamesInput = view.readCarNames()
        val roundsInput = view.readRoundCounts()

        racingGame.setup(carNamesInput, roundsInput)

        view.printRoundHeader()

        repeat(racingGame.rounds) {
            racingGame.runOneRound()
            view.printRoundResult(racingGame.getCurrentState())
        }

        val winners = racingGame.getWinners()
        view.printWinners(winners)
    }
}
