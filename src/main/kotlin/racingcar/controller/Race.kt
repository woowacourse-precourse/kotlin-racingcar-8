package racingcar.controller

import racingcar.model.CarNameParser
import racingcar.model.CarNameValidator
import racingcar.model.RaceCountValidator
import racingcar.view.InputView

class Race {

    fun run() {
        val rawCarNames = InputView.readCarNameInput()
        val raceCount = InputView.readRaceCountInput()
        RaceCountValidator.validateRaceCount(raceCount)

        val parseCarNames = CarNameParser.parseCarsNames(rawCarNames)
        CarNameValidator.validateCarName(parseCarNames)
    }
}