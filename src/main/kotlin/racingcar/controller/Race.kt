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

    private fun readAndValidateNames(): List<String> {
        val rawCarNames = InputView.readCarNameInput()
        val parseCarNames = CarNameParser.parseCarsNames(rawCarNames)
        InputValidator.validateCarName(parseCarNames)
        return parseCarNames
    }

    private fun readAndValidateRaceCount(): Int {
        val raceCount = InputView.readRaceCountInput()
        InputValidator.validateRaceCount(raceCount)
        return raceCount.toInt()
    }

    private fun initializeRace(): RaceManager {
        val raceManager = RaceManager()

        val carNames = readAndValidateNames()
        val duplicateNameAndIndex = InputValidator.findDuplicateName(carNames)
        val renamedCarNames = raceManager.addSuffixToDuplicateNames(carNames, duplicateNameAndIndex)
        raceManager.createCar(renamedCarNames)

        val raceCount = readAndValidateRaceCount()
        raceManager.setRaceCount(raceCount)

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