package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position = 0
        private set

    fun move() {
        position++
    }
}

class Race(
    private val cars: List<Car>,
    private val tryCount: Int
) {
    fun run() {
        repeat(tryCount) {
            runSingleRound()
        }
    }

    fun runSingleRound() {
        cars.forEach { car ->
            val value = Randoms.pickNumberInRange(0, 9)
            if (value >= 4) {
                car.move()
            }
        }
    }
}

fun readCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    val names = input.split(",")

    validateCarNames(names)
    return names.map { it.trim() }
}

fun readTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val input = Console.readLine()

    validateTryCount(input)
    return input.toInt()
}

fun validateCarNames(names: List<String>) {
    if (names.any { it.trim().length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
    }

    if (names.any { it.trim().isEmpty() }) {
        throw IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.")
    }
}

fun validateTryCount(input: String) {
    val count = input.toIntOrNull()
        ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")

    if (count <= 0) {
        throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
    }
}

fun main() {
    // TODO: 프로그램 구현
    try {
        val carNames = readCarNames()
        val cars = carNames.map { Car(it) }

        val tryCount = readTryCount()

        val race = Race(cars, tryCount)
        race.run()

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
