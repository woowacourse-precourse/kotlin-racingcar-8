package racingcar.controller.domain

import racingcar.view.domain.GuideView
import racingcar.view.domain.InputView

object RacingcarController {
    fun run() {
        val carNames = inputCarNames()
        val attempt = inputAttempt()
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