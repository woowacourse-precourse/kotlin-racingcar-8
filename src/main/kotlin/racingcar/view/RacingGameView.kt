package racingcar.view

import racingcar.domain.MoveStrategy
import racingcar.viewmodel.RacingGameViewModel

class RacingGameView(
    private val viewModel: RacingGameViewModel,
    private val moveStrategy: MoveStrategy
) {
    fun start() {
        setupGame()
        playGame()
        showResult()
    }

    private fun setupGame() {
        OutputView.printCarNamesPrompt()
        val carNames = InputView.readLine()
        OutputView.printRaceCountPrompt()
        val raceCount = InputView.readLine()
        viewModel.setupGame(carNames, raceCount)
    }

    private fun playGame() {
        OutputView.printStartMessage()
        repeat(viewModel.getRaceCount()) {
            val cars = viewModel.playOneRound(moveStrategy)
            OutputView.printRoundCars(cars)
            OutputView.printBlankLine()
        }
    }

    private fun showResult() {
        val winnerNames = viewModel.getWinnerNames()
        OutputView.printWinners(winnerNames)
    }
}
