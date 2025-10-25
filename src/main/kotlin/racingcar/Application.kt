package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val names = readCarNames()
    val tryCount = readTryCount()
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

private fun readTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val input = Console.readLine()
    val tryCount = input.toIntOrNull()

    validateTryCount(tryCount)

    return tryCount!!
}

private fun validateTryCount(tryCount: Int?) {
    requireNotNull(tryCount) { ExceptionMessage.INVALID_TRY_COUNT }
    require(tryCount > 0) { ExceptionMessage.INVALID_TRY_COUNT }
}