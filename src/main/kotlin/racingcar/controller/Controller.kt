package racingcar.controller

import calculator.view.InputView
import racingcar.model.RacingGame
import racingcar.view.OutputView

class Controller {
    fun run() {
        try {
            val carNames = InputView.getCarNames()
            val tries = InputView.getTries()

            val game = RacingGame(carNames, tries)

            OutputView.showRacingStart()
            repeat(game.getTries()) {
                val roundResult = game.playRound()
                OutputView.showRoundResult(roundResult)
            }

            val winners = game.getWinners()
            OutputView.showWinners(winners)
        } catch (e: IllegalArgumentException) {
            OutputView.showError(e.message ?: "잘못된 입력입니다.")
        }
    }
}