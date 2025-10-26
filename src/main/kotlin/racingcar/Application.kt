package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: 프로그램 구현
    val carNamesInput = getInputCarNames()
    val splitCarNames = splitCarName(carNamesInput)
    val round = getInputRound()

    val carInstances = splitCarNames.map { Car(it) }
    val racingGame = RacingGame(round, carInstances)
    racingGame.play()
    val winners = racingGame.getWinners()

    printOutput(winners)
}

fun getInputCarNames(): String {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNamesInput = Console.readLine()
    val hasNonCommaSpecialChar = carNamesInput.any { it != ',' && !it.isLetter() }

    require(!hasNonCommaSpecialChar) { "이름을 올바르게 입력해주세요." }
    require(carNamesInput.isNotBlank()) { "이름이 입력되지 않았습니다." }

    return carNamesInput
}

fun splitCarName(carNamesInput: String): List<String> {
    val splitCarNames = carNamesInput.split(",")
    val hasLengthFiveOrLess = splitCarNames.all { it.length <= 5 && it.isNotBlank() }
    require(hasLengthFiveOrLess) { "이름은 5글자를 초과하거나 비어있을 수 없습니다." }

    return splitCarNames
}

fun getInputRound(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val roundInput = Console.readLine()
    val round = stringToInt(roundInput)

    return round
}

fun stringToInt(roundInput: String): Int = if (roundInput.isNotBlank()) {
    roundInput.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요.")
} else {
    0
}

fun printOutput(winners: List<Car>?) {
    val winnerNames = winners?.joinToString(separator = ", ") { it.name }
    println("최종 우승자 : $winnerNames")
}

data class Car(val name: String) {
    var position: Int = 0
}

class RacingGame(val round: Int, val cars: List<Car>) {
    private var currentRound: Int = 1

    fun play() {
        println()
        println("실행 결과")
        while (!this.isFinished()) {
            this.makeMove()
            this.printRoundResult(cars)
            this.increaseCurrentRound()
        }
    }

    fun getWinners(): List<Car> {
        check(this.isFinished()) { "게임이 아직 시작되지 않았습니다." }
        val winner = cars.maxBy { it.position }
        val winners = cars.filter { it.position == winner.position }

        return winners
    }

    private fun isFinished(): Boolean = this.currentRound > this.round

    private fun makeMove() {
        cars.map {
            val randomNumber = this.getRandomNumber()
            if (canMove(randomNumber)) {
                increaseCarPosition(it)
            }
        }
    }

    private fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    private fun canMove(randomNumber: Int): Boolean = randomNumber >= 4

    private fun increaseCarPosition(car: Car) {
        car.position++
    }

    private fun increaseCurrentRound() {
        this.currentRound++
    }

    private fun printRoundResult(cars: List<Car>) {
        cars.map {
            println("${it.name} : ${"-".repeat(it.position)} ")
        }
        println()
    }
}