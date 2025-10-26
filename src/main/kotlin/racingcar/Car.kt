package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    private var position: Int = 0

    fun move() {
        val randomNumber = generateRandomNumber()
        if (shouldMove(randomNumber)) {
            position++
        }
    }

    private fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
    }

    private fun shouldMove(number: Int): Boolean {
        return number >= FORWARD_THRESHOLD
    }

    fun getPosition(): Int = position

    companion object {
        private const val MIN_RANDOM_VALUE = 0
        private const val MAX_RANDOM_VALUE = 9
        private const val FORWARD_THRESHOLD = 4
    }
}
