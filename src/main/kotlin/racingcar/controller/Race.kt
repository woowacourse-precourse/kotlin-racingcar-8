package racingcar.controller

import racingcar.model.CarNameParser
import racingcar.model.CarNameValidator
import racingcar.model.RaceManager
import racingcar.model.RaceCountValidator
import racingcar.model.WinnerCalculator
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {

    fun run() {
        val raceManager = RaceManager()
        val rawCarNames = InputView.readCarNameInput()
        val parseCarNames = CarNameParser.parseCarsNames(rawCarNames)
        CarNameValidator.validateCarName(parseCarNames)

        val raceCount = InputView.readRaceCountInput()
        RaceCountValidator.validateRaceCount(raceCount)

        raceManager.createCar(parseCarNames)
        OutputView.printStartRacing()
        repeat(raceCount.toInt(), {
            raceManager.startRound()
            OutputView.printPerRound(raceManager.getCars())
        })

        val winners = WinnerCalculator.calculateWinners(raceManager.getCars())
        OutputView.printWinners(winners)
    }
}