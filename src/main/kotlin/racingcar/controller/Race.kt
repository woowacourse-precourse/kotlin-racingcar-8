package racingcar.controller

import racingcar.model.CarNameParser
import racingcar.model.CarNameValidator
import racingcar.view.InputView

class Race {

    fun run() {
        val rawCarNames = InputView.readCarNameInput()
        val raceCount = InputView.readRaceCountInput()

        val parseCarNames = CarNameParser.parseCarsNames(rawCarNames)
        CarNameValidator.validateCarName(parseCarNames)
    }
}