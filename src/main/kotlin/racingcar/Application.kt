package racingcar

import racingcar.domain.Cars
import racingcar.game.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {

    val racingCarApplication = RacingCarApplication()
    racingCarApplication.run()
}

class RacingCarApplication {

    fun run() {
        val carNames = readUserInput()
        val roundCount = InputView.readRoundCount()

        val game = createGame(carNames)
        playGameWithOutput(game, roundCount)
        printFinalWinners(game)
    }

    private fun readUserInput(): List<String> {
        return InputView.readCarNames()
    }

    private fun createGame(carNames: List<String>): RacingGame {
        val cars = Cars(carNames)
        return RacingGame.withRandomDecider(cars)
    }

    private fun playGameWithOutput(game: RacingGame, roundCount: Int) {
        OutputView.printResultHeader()

        repeat(roundCount) {
            playSingleRound(game)
        }
    }

    private fun playSingleRound(game: RacingGame) {
        game.playRound()
        val roundResult = game.getRoundResult()
        OutputView.printRoundResult(roundResult)
    }

    private fun printFinalWinners(game: RacingGame) {
        val winners = game.getWinners()
        OutputView.printWinners(winners)
    }
}
