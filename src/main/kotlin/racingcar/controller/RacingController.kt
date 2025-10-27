package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.validator.InputValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {
    fun run() {
        val carNames = readAndValidateCarNames()
        val roundCount = readAndValidateRoundCount()

        val game = RacingGame(carNames)
        playGame(game, roundCount)
        printWinners(game)
    }

    private fun readAndValidateCarNames(): List<String> {
        val carNames = InputView.readCarNames()
        InputValidator.validateCarNames(carNames)
        return carNames
    }

    private fun readAndValidateRoundCount(): Int {
        val roundCount = InputView.readRoundCount()
        return InputValidator.validateRoundCount(roundCount)
    }

    private fun playGame(game: RacingGame, roundCount: Int) {
        OutputView.printExecutionResult()
        repeat(roundCount) {
            val cars = game.playRound()
            OutputView.printRoundResult(cars)
        }
    }

    private fun printWinners(game: RacingGame) {
        val winners = game.findWinners()
        OutputView.printWinners(winners)
    }
}
