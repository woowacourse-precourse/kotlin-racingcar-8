package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Car(
    val name: String,
    var position: Int = 0
) {
    init {
        require(name.length <= 5) { throw IllegalArgumentException() }
    }

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) position++
    }
}