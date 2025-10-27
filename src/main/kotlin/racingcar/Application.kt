package racingcar

import racingcar.domain.Judge
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingController(InputView(), OutputView(), Judge()).run()
}
