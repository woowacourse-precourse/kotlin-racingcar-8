package racingcar.controller

import racingcar.model.Car
import racingcar.view.InputView

class RacingController (
    private val inputView: InputView = InputView()
) {
    fun run() {
        val names = inputView.readCarNames()
        val count = inputView.readRoundCount()

        val cars = names.map { Car(it) }
    }
}