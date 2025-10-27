package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    fun run() {
        val names = inputView.readCarNames()
        val count = inputView.readRoundCount()

        val cars = names.map { Car(it) }
        val game = RacingGame(cars)

        outputView.printGameStart()
        repeat(count) {
            game.playRound()
            outputView.printRoundResult(cars)
        }

        outputView.printWinner(game.judgeResult())
    }
}