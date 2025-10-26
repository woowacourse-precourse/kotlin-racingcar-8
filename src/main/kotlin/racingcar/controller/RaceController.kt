package racingcar.controller

import racingcar.model.CarManager
import racingcar.model.InputParser
import racingcar.view.InputView
import racingcar.view.OutputView

object RaceController {
    private val carManager = CarManager()
    private val inputParser = InputParser()

    fun startRace() {
        val (carList, time) = initializeGame()

        carManager.addCar(carList)
        runRace(carList, time)

        val winner = carManager.returnResult()
        OutputView.finalResult(winner)
    }

    private fun initializeGame(): Pair<List<String>, Int> {
        val input = InputView.chooseCar()
        val carList = inputParser.parseCar(input)

        val tryTime = InputView.tryTime()
        val time = inputParser.parseTime(tryTime)

        return Pair(carList, time)
    }

    private fun runRace(carList: List<String>, time: Int) {
        OutputView.printResult()
        repeat(time) {
            raceSingleTime(carList)
            OutputView.printEnter()
        }
    }

    private fun raceSingleTime(carList: List<String>) {
        carList.forEach { car ->
            carManager.moveCar(car)
            val location = carManager.getCarLocation(car)
            OutputView.processResult(car, location)
        }
    }
}