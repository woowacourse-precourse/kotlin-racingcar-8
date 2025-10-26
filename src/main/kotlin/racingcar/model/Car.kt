package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position = 0

    fun move() {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) position++
    }

    fun getStatus(): String = "$name : ${"-".repeat(position)}"
}
