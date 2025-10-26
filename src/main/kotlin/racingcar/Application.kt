package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private const val MOVE_THRESHOLD = 4
private val NUMBER_RANGE = 0..9

private data class Car(val name: String, var position: Int = 0) {
    fun tryMove(rand: Int) {
        if (rand >= MOVE_THRESHOLD) position++
    }

    fun statusLine(): String = "$name : ${"-".repeat(position)}"
}


private object Validator {
    fun parseAndValidateNames(raw: String?): List<String> {
        val text = raw ?: throw IllegalArgumentException("입력이 비어 있습니다.")
        val tokens = text.split(",").map { it.trim() }
        if (tokens.isEmpty() || tokens.any { it.isEmpty() }) {
            throw IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.")
        }
        if (tokens.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.")
        }
        return tokens
    }

    fun parseAndValidateRounds(raw: String?): Int {
        val text = raw ?: throw IllegalArgumentException("입력이 비어 있습니다.")
        val n = text.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
        if (n <= 0) throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
        return n
    }
}

private object InputView {
    fun readCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = Validator.parseAndValidateNames(Console.readLine())
        return names.map { Car(it) }
    }

    fun readRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Validator.parseAndValidateRounds(Console.readLine())
    }
}

fun main() {
    val cars = InputView.readCars()
    val rounds = InputView.readRounds()
}
