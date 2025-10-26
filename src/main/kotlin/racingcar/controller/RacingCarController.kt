package racingcar.controller

import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    fun run() {
        val names = InputView.readCarNames()
        val tryCount = InputView.readTryCount()

        val race = Race(names)

        println("\n실행 결과")
        repeat(tryCount) {
            race.playRound()
            OutputView.printRound(race.cars)
        }

        val winners = race.findWinners()
        OutputView.printWinners(winners)
    }
}
