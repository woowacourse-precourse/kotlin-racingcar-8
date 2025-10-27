package racingcar

import racingcar.domain.Car
import racingcar.domain.Judge
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(val inputView: InputView, val outputView: OutputView, val judge: Judge) {
    fun run() {
        val carNames = handleCarNames()
        val repeatTime = handleRepeatTime()

        outputView.printTextOfResult()
        val raceResult = race(carNames, repeatTime.toInt())
        val winners = judge.judgeWinner(raceResult)
        outputView.printWinner(winners)
    }

    fun handleCarNames(): List<String> {
        outputView.printCarNameInputGuide()
        val inputFromUser = inputView.getCarNameFromUser()
        val carNames = Separator().separateName(inputFromUser)
        InputValidator().validateCarName(carNames)
        return carNames
    }

    fun handleRepeatTime(): String {
        outputView.printMovementTimeInputGuide()
        val repeatTime = inputView.getMovementTimeFromUser()
        InputValidator().validateTotalMovement(repeatTime)
        return repeatTime
    }

    fun race(carNames: List<String>, repeatTime: Int): List<Car> {
        val cars: List<Car> = carNames.map { carName ->
            Car(
                name = carName,
                RandomNumberGenerator()
            )
        }

        repeat (repeatTime) {
            moveCar(cars)
            printCurrentCarState(cars)
        }
        return cars
    }

    private fun moveCar(cars: List<Car>) {
        for (car in cars) {
            car.moveForward()
        }
    }

    private fun printCurrentCarState(cars: List<Car>) {
        for (car in cars) {
            outputView.printCurrentLocation(car.name, car.distance)
        }
        println()
    }
}