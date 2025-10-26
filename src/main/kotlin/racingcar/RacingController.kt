package racingcar

import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(val inputView: InputView, val outputView: OutputView) {
    fun run() {
        outputView.printCarNameInputGuide()
        val carName = inputView.getCarNameFromUser()
        val carNames = Separator().separateName(carName)
        InputValidator().validateCarName(carNames)

        outputView.printMovementTimeInputGuide()
        val repeatTime = inputView.getMovementTimeFromUser()
        InputValidator().validateTotalMovement(repeatTime)

        outputView.printTextOfResult()
        val raceResult = race(carNames, repeatTime.toInt())
        judgeWinner()
        printWinner()
    }

    fun race(carNames: List<String>, repeatTime: Int): List<Car> {
        val cars: List<Car> = carNames.map(::Car)

        for(i in 0 until repeatTime) {
            moveCar(cars)
            printCurrentCarState(cars)
        }
        return cars
    }

    private fun moveCar(cars: List<Car>) {
        for(car in cars) {
            car.moveForward()
        }
    }

    private fun printCurrentCarState(cars: List<Car>) {
        for(car in cars) {
            outputView.printCurrentLocation(car.name, car.distance)
        }
        println()
    }
}