package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    // 자동차 이름 입력
    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        if (input.isBlank()) {
            throw IllegalArgumentException("자동차 이름을 입력해주세요!")
        }
        // 공백도 고려
        return input.split(",").map { it.trim() }
    }

    // 경주를 시도할 횟수 입력
    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력해주세요!")
        require(count >= 0) { "양수 값을 입력해주세요!" }
        return count
    }
}