package racingcar

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

        val names = Console.readLine()
        val carNames = names.split(",").map { it.trim() }

        if (names.isBlank()) {
            throw IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.")
        }

        carNames.forEach { name ->
            if (name.length > 5) {
                throw IllegalArgumentException("자동차 이름 '$name'은 5자를 초과할 수 없습니다.")
            }
            if (name.isEmpty()) {
                throw IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.")
            }
        }

        val uniqueNames = carNames.toSet()
        if (uniqueNames.size != carNames.size) {
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
        }

        return carNames
    }
}