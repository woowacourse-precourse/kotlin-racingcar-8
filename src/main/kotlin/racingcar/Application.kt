package racingcar

import racingcar.controller.UserController
import racingcar.service.AttemptCountValidator
import racingcar.service.CarNameValidator
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView

fun main() {
    // TODO: 프로그램 구현
    val userController = UserController(ConsoleOutputView(), ConsoleInputView, CarNameValidator())
    userController.run()
}

