package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val cars: List<String> = readCarNames()
    val tryCount: Int = readTryCount()

    val positions: MutableMap<String, Int> = mutableMapOf()
    cars.forEach { carName ->
        positions[carName] = 0
    }

    println("실행 결과")
    repeat(tryCount) {
        raceOnce(cars, positions)
        printRoundResult(cars, positions)
    }
    printWinners(cars, positions)
}

fun readCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val rawInput = Console.readLine()

    val names = rawInput
        .split(",")
        .map { it.trim() }
        .filter { it.isNotEmpty() }

    if (names.isEmpty()) {
        throw IllegalArgumentException("자동차 이름은 최소 1개 이상이어야 합니다.")
    }

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

    if (!rawInput.matches(Regex("^[0-9]+$"))) {
        throw IllegalArgumentException("이동 횟수는 숫자여야 합니다.")
    }

    val count = rawInput.toInt()

    return count
}

fun raceOnce(cars: List<String>, positions: MutableMap<String, Int>) {
    cars.forEach { carName ->
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            positions[carName] = positions.getValue(carName) + 1
        }
    }
}

fun printRoundResult(cars: List<String>, positions: Map<String, Int>) {
    cars.forEach { carName ->
        val distance = positions.getValue(carName)
        val bar = "-".repeat(distance)
        println("$carName : $bar")
    }
    println()
}

fun printWinners(cars: List<String>, positions: Map<String, Int>) {
    val maxDistance = positions.values.maxOrNull()
        ?: throw IllegalStateException("우승자를 계산할 수 없습니다.")

    val winners = cars.filter { carName ->
        positions.getValue(carName) == maxDistance
    }

    val result = winners.joinToString(separator = ", ")

    println("최종 우승자 : $result")
}