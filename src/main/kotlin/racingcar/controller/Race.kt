package racingcar.controller

import racingcar.view.InputView

class Race {

    fun run() {
        val rawCarNames = InputView.readCarNameInput()
        val raceCount = InputView.readRaceCountInput()
    }
}