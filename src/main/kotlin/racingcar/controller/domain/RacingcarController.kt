package racingcar.controller.domain

import racingcar.model.domain.Attempt
import racingcar.model.domain.CarName
import racingcar.model.domain.Winner
import racingcar.view.domain.GuideView
import racingcar.view.domain.InputView
import racingcar.view.domain.ResultView

object RacingcarController {
    fun run() {
        val carNames = inputCarNames()
        val attempt = inputAttempt()

        val splitName = CarName.split(carNames)
        val checkedAttempt = Attempt.toInt(attempt)

        val carController = CarController(splitName, checkedAttempt)
        carController.startRacing()
        val history = carController.history

        val winner = Winner
        val winnerIndex = winner.find(history.last())
        val winnerString = winner.join(winnerIndex, splitName)

        ResultView.consoleLine()
        ResultView.consoleProgress(splitName, history)
        ResultView.consoleWinner(winnerString)
    }

    private fun inputCarNames(): String {
        GuideView.consoleName()
        return InputView.console()
    }

    private fun inputAttempt(): String {
        GuideView.consoleAttempt()
        return InputView.console()
    }
}