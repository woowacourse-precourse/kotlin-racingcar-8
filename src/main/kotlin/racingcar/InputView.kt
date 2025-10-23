package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        return input.split(",").map { it.trim() }
    }

    fun readAttemptCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
    }
}






