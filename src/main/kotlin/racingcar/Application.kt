package racingcar

import racingcar.adaptors.controller.UserController
import racingcar.application.validator.CarNameValidator
import racingcar.adaptors.view.ConsoleInputView
import racingcar.adaptors.view.ConsoleOutputView

fun main() {
    // TODO: 프로그램 구현
    val userController = UserController(ConsoleOutputView(), ConsoleInputView, CarNameValidator())
    userController.run()
}

