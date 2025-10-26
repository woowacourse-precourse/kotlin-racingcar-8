package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine().trim()
        require(input.isNotBlank()) { "자동차 이름을 입력해야 합니다." }

        val names = input.split(",").map { it.trim() }
        require(names.all { it.length in 1..5 }) { "자동차 이름은 1자 이상, 5자 이하여야 합니다." }

        return names
    }

    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine().trim()
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
        require(number > 0) { "시도 횟수는 1 이상이어야 합니다." }
        return number
    }
}
