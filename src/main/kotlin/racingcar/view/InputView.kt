package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constant.InputMessage

object InputView {

    private fun prompt(message: InputMessage): String {
        println(message.text)
        return Console.readLine() ?: ""
    }

    fun readParticipants(): String = prompt(InputMessage.NAME)

    fun readRound(): String = prompt(InputMessage.ROUND)

}