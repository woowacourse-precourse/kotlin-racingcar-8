package racingcar.controller

import racingcar.model.CarNameParser
import racingcar.model.CarNameValidator
import racingcar.model.Cars
import racingcar.model.RaceCountValidator
import racingcar.model.WinnerCalculator
import racingcar.view.InputView
import racingcar.view.OutputView

class Race {

    fun run() {
        val cars = Cars()
        val rawCarNames = InputView.readCarNameInput()
        val raceCount = InputView.readRaceCountInput()
        RaceCountValidator.validateRaceCount(raceCount)

        val parseCarNames = CarNameParser.parseCarsNames(rawCarNames)
        CarNameValidator.validateCarName(parseCarNames)

        cars.createCar(parseCarNames)
        OutputView.printStartRacing()
        repeat(raceCount.toInt(), {
            cars.startRound()
            OutputView.printPerRound(cars.getCars())
        })

        val winners = WinnerCalculator.calculateWinners(cars.getCars())
        OutputView.printWinners(winners)
    }
}