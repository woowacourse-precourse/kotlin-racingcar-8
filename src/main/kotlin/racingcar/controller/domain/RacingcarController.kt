package racingcar.controller.domain

import racingcar.model.domain.CarName
import racingcar.view.domain.GuideView
import racingcar.view.domain.InputView

object RacingcarController {
    fun run() {
        val carNames = inputCarNames()
        val attempt = inputAttempt()

        val splitName = CarName.split(carNames)
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