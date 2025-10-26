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
        // 뷰 모델을 통해 이름 판단
        viewModel.setupGame(carNames)

        val racingCount = inputView.readRacingCount()
        // 뷰 모델을 통해 시도 횟수 판단
        viewModel.coutninueGame(racingCount)

        println()
        println("실행 결과")
        repeat(racingCount) {
            viewModel.playOneRound()
            outputView.printRoundResult(viewModel.getCurrentStatus())
        }

        val winners = viewModel.getWinners()
        outputView.printWinners(winners)
    }
}