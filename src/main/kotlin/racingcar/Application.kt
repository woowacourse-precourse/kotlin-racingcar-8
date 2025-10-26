package racingcar

import car.view.InputView
import car.viewmodel.RacingViewModel

fun main() {
    Application().run()
}

class Application {
    fun run() {
        val inputView = InputView()
        val viewModel = RacingViewModel()

        val carNames = inputView.readCarNames()
        viewModel.setupGame(carNames)
    }
}