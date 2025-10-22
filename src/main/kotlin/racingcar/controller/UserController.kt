package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView

class UserController(private val outputView: OutputView, private val inputView: InputView) {
    fun run() {
        outputView.printCarNamesPrompt()
        inputView.readCarNames()
        outputView.printAttemptCountPrompt()
        inputView.readAttemptCount()
    }

}