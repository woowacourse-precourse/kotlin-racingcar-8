package racingcar

import racingcar.controller.RacingGameController
import racingcar.exception.CarNameInputValidator
import racingcar.exception.CountAttemptInputValidator
import racingcar.model.Parser
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val controller = RacingGameController(
        InputView(),
        OutputView(),
        CarNameInputValidator(),
        CountAttemptInputValidator(),
        Parser()
    )
    controller.run()
}
