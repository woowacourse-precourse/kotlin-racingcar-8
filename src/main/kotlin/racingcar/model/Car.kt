package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0) {

    companion object {
        private const val MIN_RANDOM_VALUE = 0
        private const val MAX_RANDOM_VALUE = 9
        private const val MIN_MOVE_VALUE = 4
    }

    fun move() {
        val random = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
        if (random >= MIN_MOVE_VALUE) position++
    }
}