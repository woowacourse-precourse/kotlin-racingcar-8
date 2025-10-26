package racingcar

import camp.nextstep.edu.missionutils.Console

object InputUtil {
    fun readNames(): List<String> {
        val list = Console.readLine().split(",")
        return list
    }
}
