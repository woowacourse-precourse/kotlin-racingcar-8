package racingcar

import car.model.RandomMove
import car.view.InputView
import car.view.OutputView
import car.viewmodel.RacingViewModel

fun main() {
    Application().run()
}

class Application {

    fun run() {
        val inputView = InputView()
        val outputView = OutputView()
        val moveStrategy = RandomMove()
        val viewModel = RacingViewModel(moveStrategy)

        val carNames = inputView.readCarNames()
        viewModel.setupGame(carNames)

        val racingCount = inputView.readRacingCount()

        println()
        println("실행 결과")
        repeat(racingCount) {
            viewModel.playOneRound()
            outputView.printRoundResult(viewModel.getCurrentStatus())
        }
    }
}