package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현

    // 입력
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNamesInput = Console.readLine()
    val hasNonCommaSpecialChar = carNamesInput.any { it != ',' && !it.isLetter() }
    require(!hasNonCommaSpecialChar) { "이름을 올바르게 입력해주세요." }

    require(carNamesInput.isNotBlank()) { "이름이 입력되지 않았습니다." }

    val splitCarName = carNamesInput.split(",")
    val hasLengthFiveOrLess = splitCarName.all { it.length <= 5 && it.isNotBlank() }
    require(hasLengthFiveOrLess) { "이름은 5글자를 초과하거나 비어있을 수 없습니다." }

    println("시도할 횟수는 몇 회인가요?")
    val roundInput = Console.readLine()
    val round = stringToInt(roundInput)

    val carInstances = splitCarName.map { Car(it) }
    val racingGame = RacingGame(round, carInstances)

}

private fun stringToInt(roundInput: String): Int =
    if (roundInput.isNotBlank()) {
    roundInput.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요.")
    } else {
        0
    }

data class Car(val name: String) {
    var position: Int = 0
}

class RacingGame(val round: Int, val cars: List<Car>) {

}