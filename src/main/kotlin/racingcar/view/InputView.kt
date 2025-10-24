package racingcar.view
import camp.nextstep.edu.missionutils.Console.readLine
private const val CAR_NAME_DELIMITER = ","

object InputView {
    fun readCarNames(): List<String> {
        val input = readLine()
        return input.split(CAR_NAME_DELIMITER) .map {it.trim()}
    }

    fun readRepeatNum(): String {
        return readLine()
    }
}