package racingcar

import camp.nextstep.edu.missionutils.Console

object InputUtil {
    fun readNames(): List<String> {
        val list = Console.readLine().split(",")
        list.forEach {
            if (it.length > 5) throw IllegalArgumentException()
        }
        return list
    }

    fun readTries() = Console.readLine().toInt()
}
