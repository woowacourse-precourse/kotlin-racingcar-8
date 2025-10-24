package racingcar

import racingcar.domain.Car
import racingcar.view.InputView

class RacingController(val inputView: InputView, outputView: OutputView) {
    fun run() {
        val carName = inputView.getCarNameFromUser()
        val carNames = Separator().separateName(carName)
        InputValidator().validateCarName(carNames)

        val repeatTime = inputView.getMovementTimeFromUser()
        InputValidator().validateTotalMovement(repeatTime)

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