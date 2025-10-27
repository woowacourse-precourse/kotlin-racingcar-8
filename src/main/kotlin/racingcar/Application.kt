package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNamesInput = Console.readLine()

    val carNames = validateCarNames(carNamesInput)

    println("시도할 횟수는 몇 회인가요?")
    val tryCountInput = Console.readLine()

    val tryCount = validateTryCount(tryCountInput)

    val cars = createCars(carNames)

    runRace(cars, tryCount)

    val winners = findWinners(cars)
    printWinners(winners)
}

data class Car(
    val name: String,
    var position: Int = 0
) {
    fun moveForward() {
        val randomValue = Randoms.pickNumberInRange(0, 9)
        if (randomValue >= 4) {
            this.position += 1
        }
    }
}

private fun validateCarNames(carNamesInput: String?): List<String> {
    val names = carNamesInput?.split(",")
        ?: throw IllegalArgumentException("입력이 없습니다.")

    for (name in names) {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름이 비었습니다.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("이름이 5자를 초과하였습니다.")
        }
    }

    return names
}

private fun validateTryCount(tryCountInput: String?): Int {
    if (tryCountInput.isNullOrBlank()) {
        throw IllegalArgumentException("시도 횟수 입력을 안했습니다.")
    }

    val count = tryCountInput.toIntOrNull()
        ?: throw IllegalArgumentException("입력된 시도 횟수가 정수가 아닙니다.")

    if (count < 0) {
        throw IllegalArgumentException("입력된 시도 횟수가 음수입니다.")
    }

    return count
}

private fun createCars(carNames: List<String>): List<Car> {
    return carNames.map { name -> Car(name.trim()) }
}

private fun runRace(cars: List<Car>, tryCount: Int) {
    println("\n실행 결과")

    repeat(tryCount) {
        moveAllCars(cars)
        printTryResult(cars)
        println()
    }
}

private fun moveAllCars(cars: List<Car>) {
    for (car in cars) {
        car.moveForward()
    }
}

private fun printTryResult(cars: List<Car>) {
    for (car in cars) {
        val positionMarker = "-".repeat(car.position)
        println("${car.name} : $positionMarker")
    }
}

private fun findWinners(cars: List<Car>): List<String> {
    var maxPosition = 0

    for (car in cars) {
        if (car.position > maxPosition) {
            maxPosition = car.position
        }
    }

    val winners = mutableListOf<String>()
    for (car in cars) {
        if (car.position == maxPosition) {
            winners.add(car.name)
        }
    }
    return winners
}

private fun printWinners(winners: List<String>) {
    val winnerNames = winners.joinToString(", ")
    println("최종 우승자 : $winnerNames")
}