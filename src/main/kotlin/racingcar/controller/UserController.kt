package racingcar.controller

import racingcar.service.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class UserController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val carNameValidator: Validator,
) {
    fun run() {
        outputView.printCarNamesPrompt()
        carNameValidator.validate(inputView.readCarNames())
        outputView.printAttemptCountPrompt()
    }

}