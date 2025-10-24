package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarNameInput(): String {
        val carName = Console.readLine()
        return carName
    }

    fun readCountOfAttempt(): String {
        val countOfAttempt = Console.readLine()
        return countOfAttempt
    }
}