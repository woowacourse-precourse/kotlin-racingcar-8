package racingcar.controller

import racingcar.model.CarManager
import racingcar.model.InputParser
import racingcar.view.Input
import racingcar.view.Output

class RaceController(
    private val carManager: CarManager,
    private val inputParser: InputParser,
    private val inputView: Input,
    private val outputView: Output,
) {

    fun startRace() {
        val (cars, time) = initializeGame()

        carManager.addCar(cars)
        runRace(cars, time)

        val winner = carManager.returnResult()
        outputView.finalResult(winner)
    }

    private fun initializeGame(): Pair<List<String>, Int> {
        val input = inputView.chooseCar()
        val cars = inputParser.parseCar(input)

        val tryTime = inputView.tryTime()
        val time = inputParser.parseTime(tryTime)

        return Pair(cars, time)
    }

    private fun runRace(cars: List<String>, time: Int) {
        outputView.printResult()
        repeat(time) {
            raceSingleTime(cars)
            println()
        }
    }

    private fun raceSingleTime(cars: List<String>) {
        cars.forEach { car ->
            carManager.moveCar(car)
            val location = carManager.getCarLocation(car)
            outputView.processResult(car, location)
        }
    }
}