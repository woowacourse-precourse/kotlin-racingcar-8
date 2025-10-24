package racingcar.view
import camp.nextstep.edu.missionutils.Console.readLine

object InputView {
    fun readCarNames(): List<String> {
        val input = readLine()
        return input.split(",")
    }

    fun readRepeatNum(): String {
        return readLine()
    }
}