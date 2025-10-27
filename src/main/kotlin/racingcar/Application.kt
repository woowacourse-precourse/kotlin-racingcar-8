package racingcar

import racingcar.view.Input
import racingcar.view.Output
import racingcar.viewModel.CarRacingGameViewModel

fun main() {
    val input = Input()
    val output = Output()
    val gameViewModel = CarRacingGameViewModel()
    val carNames = gameViewModel.validateCarName(input.getCarsName())
    val tryCount = gameViewModel.validateTryCount(Input().getTryCount())

    gameViewModel.gameSetting(carNames)

    gameViewModel.runAllGames(tryCount).forEach { gameResult ->
        output.printGamesResult(gameResult)
    }

    output.finalWinners(gameViewModel.getWinnerNames())
}
