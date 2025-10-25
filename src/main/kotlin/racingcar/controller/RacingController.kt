package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.WinnerCalculator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun startGame() {
        val carNames = inputView.readCarNames()
        val tryCount = inputView.readTryCount()

        val game = RacingGame(carNames)

        outputView.printStartMessage()
        repeat(tryCount) {
            game.moveCars()
            outputView.printRound(game.cars)
        }

        val winners = WinnerCalculator.calculate(game.cars)
        outputView.printWinners(winners)
    }
}
