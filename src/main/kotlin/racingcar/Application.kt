package racingcar

import racingcar.controller.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val names = InputView.readCarNames()
    val tryCount = InputView.readTryCount()

    println("\n실행 결과")
    val game = RacingGame(names, tryCount)
    val winners = game.start()

    ResultView.printWinners(winners)
}
