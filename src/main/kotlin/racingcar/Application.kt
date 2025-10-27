package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    RacingGame().start()
}

class RacingGame {
    fun start() {
        val carNames = getCarNames()
        // TODO: 시도할 횟수 입력 기능 구현
    }

    private fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine() ?: ""
        val names = input.split(",").map { it.trim() }

        validateCarNames(names)
        return names
    }

    private fun validateCarNames(names: List<String>) {
        if (names.any { it.isBlank() }) {
            throw IllegalArgumentException("자동차 이름은 공백이거나 비어있을 수 없습니다.")
        }
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
    }
}