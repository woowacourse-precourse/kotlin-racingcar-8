package racingcar.controller

import calculator.view.InputView

class Controller {
    fun run() {
        val carNames = InputView.getCarNames()
        val tries = InputView.getTries()
    }
}