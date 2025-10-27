package racingcar.adaptors.view

import camp.nextstep.edu.missionutils.Console

object ConsoleInputView : InputView {

    override fun readCarNames(): String {
        return Console.readLine()
    }

    override fun readAttemptCount(): String {
        return Console.readLine()
    }
}