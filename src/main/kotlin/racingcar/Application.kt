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
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNamesInput = Console.readLine() ?: throw IllegalArgumentException("자동차 이름이 입력되지 않았습니다.")
    val carNames = carNamesInput.split(',').map { it.trim() }
    println("시도할 횟수는 몇 회인가요?")
    val tryCountInput = Console.readLine() ?: throw IllegalArgumentException("시도 횟수가 입력되지 않았습니다.")
}
