package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0) {

    fun move() {
        val random = Randoms.pickNumberInRange(0, 9)
        if (random >= 4) position++
    }
}