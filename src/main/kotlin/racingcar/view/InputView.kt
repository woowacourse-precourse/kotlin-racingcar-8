package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }

        validateCarNames(names)
        return names
    }

    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        val count = input.toIntOrNull()
            ?: throw IllegalArgumentException("숫자를 입력해야 합니다.")

        validateTryCount(count)
        return count
    }

    private fun validateCarNames(names: List<String>) {
        if (names.isEmpty() || names.any { it.isEmpty() })
            throw IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.")
        if (names.any { it.length > 5 })
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
    }

    private fun validateTryCount(count: Int) {
        if (count <= 0)
            throw IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.")
    }
}
