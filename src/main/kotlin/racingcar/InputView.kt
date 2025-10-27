package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val DELIMITER = ","

    fun readCarNames(): List<String> {
        println(CAR_NAMES_INPUT_MESSAGE)
        val input = Console.readLine()
        return input.split(DELIMITER).map { it.trim() }
    }

    fun readAttemptCount(): Int {
        println(ATTEMPT_COUNT_INPUT_MESSAGE)
        return Console.readLine().toInt()
    }
}
