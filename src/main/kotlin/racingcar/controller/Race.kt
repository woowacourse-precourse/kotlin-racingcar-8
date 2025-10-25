package racingcar.controller

import racingcar.model.CarNameParser
import racingcar.model.InputValidator
import racingcar.model.RaceManager
import racingcar.model.WinnerCalculator
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {

    fun run() {
        val raceManager = RaceManager()
        val rawCarNames = InputView.readCarNameInput()
        val parseCarNames = CarNameParser.parseCarsNames(rawCarNames)
        InputValidator.validateCarName(parseCarNames)

        val raceCount = InputView.readRaceCountInput()
        InputValidator.validateRaceCount(raceCount)

        val duplicateNameAndIndex = InputValidator.findDuplicateName(parseCarNames)

        val renamedCarNames = raceManager.addSuffixToDuplicateNames(parseCarNames, duplicateNameAndIndex)
        raceManager.createCar(renamedCarNames)
        OutputView.printStartRacing()
        repeat(raceCount.toInt(), {
            raceManager.startRound()
            OutputView.printPerRound(raceManager.getCars())
        })

        val winners = WinnerCalculator.calculateWinners(raceManager.getCars())
        OutputView.printWinners(winners)
    }
}