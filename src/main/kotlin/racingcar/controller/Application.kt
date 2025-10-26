package racingcar.controller

import racingcar.exception.CarNameInputValidator
import racingcar.exception.CountAttemptInputValidator
import racingcar.model.Parser
import racingcar.view.InputView

fun main() {
    val controller = RacingGameController(
        inputView = InputView(),
        carNamesValidator = CarNameInputValidator(),
        countAttemptValidator = CountAttemptInputValidator(),
        parser = Parser()
    )
    controller.run()
}
