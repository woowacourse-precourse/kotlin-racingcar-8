package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.Validator
import racingcar.util.RandomNumberGenerator

class RacingController {
    fun start() {
        val carNameList = readAndValidateCarNames()
        val repeatNum = readAndValidateRepeatNum()
        val racingGame = RacingGame(RandomNumberGenerator())
        val initialCars = carNameList.map { Car(it) }
        playRace(racingGame, initialCars, repeatNum)
    }

    private fun readAndValidateCarNames(): List<String> {
        OutputView.printCarInputInstruction()
        val carNames = InputView.readCarNames()
        Validator.validateCarNames(carNames)
        return carNames
    }

    private fun readAndValidateRepeatNum(): Int {
        OutputView.printRepeatNumInputInstruction()
        val input = InputView.readRepeatNum()
        Validator.validateRepeatNum(input)
        return input.toInt()
    }

    private fun playRace(racingGame: RacingGame, cars: List<Car>, repeatNum: Int) {
        OutputView.printResultHeader()
        var currentCars = cars
        repeat(repeatNum) {
            currentCars = racingGame.raceOneRound(currentCars)
            OutputView.printRaceProcess(currentCars)
        }
        OutputView.printRaceWinners(racingGame.findWinners(currentCars))
    }

}