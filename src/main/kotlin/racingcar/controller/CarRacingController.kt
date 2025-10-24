package racingcar.controller

import racingcar.service.CarService
import racingcar.view.InputView
import racingcar.view.OutputView

class CarRacingController(
    private val carService: CarService = CarService()
) {
    fun run() {
        OutputView.displayCarNamePrompt()
        val cars = carService.createCars(InputView.readInput())

        OutputView.displayAttemptCountPrompt()
        val attemptCount = InputView.readInput()
    }
}