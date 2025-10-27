package racingcar.controller

import racingcar.view.Input

class FakeInput(private val carInput: String, private val timeInput: String) : Input {
    override fun chooseCar(): String = carInput
    override fun tryTime(): String = timeInput
}