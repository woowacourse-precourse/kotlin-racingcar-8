package racingcar

import racingcar.domain.Car
import racingcar.domain.RandomMoveDecider
import racingcar.service.RaceRound
import racingcar.service.WinnerFinder
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val names = InputView.readNames()
    val trialCount = InputView.readTrialCount()

    val cars = names.map{ Car(it)}
    val decider= RandomMoveDecider()
    val raceRound= RaceRound(decider)

    OutputView.printStart()
    repeat(trialCount){
        raceRound.runOnce(cars)
        OutputView.printRound(cars)
    }
    OutputView.printWinners(
        WinnerFinder.findWinners(cars));
}
