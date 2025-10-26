package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val cars: List<String> = readCarNames()
    println("자동차 리스트: $cars")
}

fun readCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val rawInput = Console.readLine()

    val names = rawInput
        .split(",")
        .map { it.trim() }
        .filter { it.isNotEmpty() }

    names.forEach { name ->
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다: $name")
        }
    }

    return names
}