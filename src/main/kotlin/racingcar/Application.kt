package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0) {

    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)

        if (isMovable(randomNumber)) {
            position++
        }
    }

    private fun isMovable(randomNumber: Int): Boolean {
        return randomNumber >= 4
    }

    fun getPositionString(): String {
        return name + " : " + "-".repeat(position)
    }
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNamesInput = Console.readLine() ?: throw IllegalArgumentException("자동차 이름이 입력되지 않았습니다.")
    val carNames = carNamesInput.split(',').map { it.trim() }

    if (carNames.isEmpty()) {
        throw IllegalArgumentException("자동차 이름 목록이 비어있습니다.")
    }

    carNames.forEach { name ->
        if (name.isBlank() || name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다. (잘못된 이름: $name)")
        }
    }

    println("시도할 횟수는 몇 회인가요?")
    val tryCountInput = Console.readLine() ?: throw IllegalArgumentException("시도 횟수가 입력되지 않았습니다.")
    val tryCount = tryCountInput.toIntOrNull()

    if (tryCount == null || tryCount <= 0) {
        throw IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다. (입력값: $tryCountInput)")
    }

    startRacing(carNames, tryCount)
}

private fun startRacing(carNames: List<String>, tryCount: Int) {
    val cars = carNames.map { Car(it) }

    println("\n실행 결과")
    repeat(tryCount) {
        executeSingleRound(cars)
        println()
    }

    printWinners(cars)
}

private fun executeSingleRound(cars: List<Car>) {
    cars.forEach { car ->
        car.move()
    }

    printRoundResult(cars)
}

private fun printRoundResult(cars: List<Car>) {
    cars.forEach { car ->
        println(car.getPositionString())
    }
}

private fun printWinners(cars: List<Car>) {
    val maxPosition = cars.maxOfOrNull { it.position } ?: 0 // Depth 1
    val winners = cars.filter { it.position == maxPosition }
    val winnerNames = winners.joinToString(", ") { it.name }

    println("최종 우승자 : $winnerNames")
}