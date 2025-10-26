package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val raw = Console.readLine()
        val names = raw.split(",").map { it.trim() }
        validateNames(names)
        return names
    }

    fun readTrialCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val raw = Console.readLine()
        val count = raw.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수는 정수여야 합니다.")
        if (count < 1) throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
        return count
    }

    private fun validateNames(names: List<String>) {
        if (names.isEmpty()) throw IllegalArgumentException("이름을 하나 이상 입력하세요.")
        names.forEach { name ->
            if (name.isBlank()) throw IllegalArgumentException("빈 이름은 허용되지 않습니다.")
            if (name.length !in 1..5) throw IllegalArgumentException("각 이름은 1~5자여야 합니다.")
        }
    }
}
