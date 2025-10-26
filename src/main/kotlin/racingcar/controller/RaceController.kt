package racingcar.controller

import racingcar.model.CarManager
import racingcar.model.InputParser
import racingcar.view.InputView
import racingcar.view.OutputView

object RaceController {
    private val carManager = CarManager()
    private val inputParser = InputParser()

    fun startRace() {
        val input = InputView.chooseCar()
        val carList = inputParser.parseCar(input)

        val tryTime = InputView.tryTime()
        val time = inputParser.parseTime(tryTime)
        // 회차 진행하면 될듯
        carManager.addCar(carList)
        OutputView.printResult()
        repeat(time) {
            carList.forEach { car ->
                carManager.moveCar(car)
                val location = carManager.getCarLocation(car)
                OutputView.processResult(car, location)
            }
            OutputView.printEnter()
        }
        val winner = carManager.returnResult()
        OutputView.finalResult(winner)
    }
}