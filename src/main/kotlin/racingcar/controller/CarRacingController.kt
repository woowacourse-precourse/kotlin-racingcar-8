package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView

class CarRacingController {
    fun run() {
        OutputView.displayCarNamePrompt()
        val carNames = InputView.readInput()

        OutputView.displayAttemptCountPrompt()
        val attemptCount = InputView.readInput()
    }
}