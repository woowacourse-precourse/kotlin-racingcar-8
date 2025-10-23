package racingcar.controller

import racingcar.validator.Validator
import racingcar.view.InputView

class Controller {
    fun run() {

        val inputName = InputView.readParticipants()
        Validator.validateNotBlank(inputName)
    }

}