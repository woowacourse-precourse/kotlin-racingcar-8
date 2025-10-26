package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val cars: List<String> = readCarNames()
    val tryCount: Int = readTryCount()
    println("자동차 리스트: $cars")
    println("이동 횟수: $tryCount")
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

fun readTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")

    val rawInput = Console.readLine().trim()

    // 숫자인지 확인
    if (!rawInput.matches(Regex("^[0-9]+$"))) {
        throw IllegalArgumentException("이동 횟수는 숫자여야 합니다.")
    }

    val count = rawInput.toInt()

    return count
}