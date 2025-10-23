package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readParticipants(): String {
        return Console.readLine() ?: ""
    }
}