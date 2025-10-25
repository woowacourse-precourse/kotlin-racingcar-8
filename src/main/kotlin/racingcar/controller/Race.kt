package racingcar.controller

import racingcar.model.CarNameParser
import racingcar.model.InputValidator
import racingcar.model.RaceManager
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {

    fun run() {
        val raceManager = initializeRace()
        startRace(raceManager)
        endRace(raceManager)
    }

    private fun initializeRace(): RaceManager {
        val raceManager = RaceManager()
        val rawCarNames = InputView.readCarNameInput()
        val parseCarNames = CarNameParser.parseCarsNames(rawCarNames)
        InputValidator.validateCarName(parseCarNames)

        val raceCount = InputView.readRaceCountInput()
        InputValidator.validateRaceCount(raceCount)
        raceManager.setRaceCount(raceCount.toInt())

        val duplicateNameAndIndex = InputValidator.findDuplicateName(parseCarNames)

        val renamedCarNames = raceManager.addSuffixToDuplicateNames(parseCarNames, duplicateNameAndIndex)
        raceManager.createCar(renamedCarNames)

        return raceManager
    }

    private fun startRace(raceManager: RaceManager) {
        OutputView.printStartRacing()
        repeat(raceManager.getRaceCount()) {
            raceManager.startRound()
            OutputView.printPerRound(raceManager.getCars())
        }
    }

    private fun endRace(raceManager: RaceManager) {
        val winners = raceManager.calculateWinners()
        OutputView.printWinners(winners)
    }
}