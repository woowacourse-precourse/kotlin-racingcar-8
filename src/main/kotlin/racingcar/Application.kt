package racingcar

import racingcar.controller.UserController
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView
import racingcar.view.InputView

fun main() {
    // TODO: 프로그램 구현
    val userController = UserController(ConsoleOutputView(), ConsoleInputView)
    userController.run()
}

