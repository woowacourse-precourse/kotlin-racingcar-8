package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val names = readCarNames()
}

private fun readCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()

    val names = input.split(",")
        .map { it.trim() }
        .filter { it.isNotBlank() }

    validateCarNames(names, input)

    return names
}

private fun validateCarNames(names: List<String>, input: String) {
    val inputCommaCount = input.count { it == ',' }

    require(names.size == inputCommaCount + 1) { ExceptionMessage.INVALID_NAME_FORMAT }
}