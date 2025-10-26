package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Constants.ATTEMPT_MESSAGE
import racingcar.util.Constants.CAR_NAME_MESSAGE

class InputView {
//    자동차 이름 입력
    fun carNameInputView(): String {
        printMessage(CAR_NAME_MESSAGE)
        return Console.readLine()
    }

//      시도횟수 입력
    fun attemptInputView(): String {
        printMessage(ATTEMPT_MESSAGE)
        return Console.readLine()
    }

    private fun printMessage(message: String) {
        println(message)
    }
}