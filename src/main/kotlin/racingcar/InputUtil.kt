package racingcar

import camp.nextstep.edu.missionutils.Console

object InputUtil {
    fun readNames(): List<String> {
        val list = Console.readLine().split(",")
        list.forEach {
            if (it.isBlank()) throw IllegalArgumentException()
            if (it.length > 5) throw IllegalArgumentException()
        }
        return list
    }

    fun readTries() = try {
        Console.readLine().toInt().takeIf { it >= 0 } ?: throw IllegalArgumentException()
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException()
    }
}
