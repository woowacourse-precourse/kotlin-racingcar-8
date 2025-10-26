package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val names = InputView.readNames()
    val trialCount = InputView.readTrialCount()

    // 이후 게임 로직 진행
    OutputView.printStart()
    // ... 나중에 RaceRound, WinnerFinder 등 연결
}
