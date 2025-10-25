package racingcar.controller

import racingcar.view.InputView

class RacingController (
    private val inputView: InputView = InputView()
) {
    fun run() {
        val names = inputView.readCarNames()
        val count = inputView.readRoundCount()
    }
}