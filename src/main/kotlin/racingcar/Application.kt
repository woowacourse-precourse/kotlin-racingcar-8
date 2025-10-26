package racingcar

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
    // TODO: 프로그램 구현
}
