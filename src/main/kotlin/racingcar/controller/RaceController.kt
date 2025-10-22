package racingcar.controller

import racingcar.util.InputParser
import racingcar.view.InputView

class RaceController(
    private val inputView: InputView,
    private val inputParser: InputParser
) {
    fun run() {
        val readCarNames = inputView.readCarNames()
        val readTryCount = inputView.readTryCount()

        val carNames = inputParser.parseCarNames(readCarNames)
    }
}