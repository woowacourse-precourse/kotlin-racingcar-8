package racingcar.controller

import racingcar.service.car.CarService
import racingcar.service.racing.RacingService
import racingcar.view.InputView
import racingcar.view.OutputView

class CarRacingController(
    private val carService: CarService = CarService(),
    private val racingService: RacingService = RacingService()
) {
    fun run() {
        OutputView.displayCarNamePrompt()
        val cars = carService.createCars(InputView.readInput())

        OutputView.displayAttemptCountPrompt()
        val result = racingService.race(InputView.readInput(), cars)

        OutputView.displayResult(result)
    }
}