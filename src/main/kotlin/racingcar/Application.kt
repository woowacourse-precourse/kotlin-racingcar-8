package racingcar

import racingcar.controller.UserController
import racingcar.view.ConsoleOutputView

fun main() {
    // TODO: 프로그램 구현
    val userController = UserController(ConsoleOutputView())
    userController.run()
}

