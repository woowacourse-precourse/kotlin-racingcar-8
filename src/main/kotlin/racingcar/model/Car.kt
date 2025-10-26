package racingcar.model

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class Car(private val name: String) {
    private var distance: Int = 0

    fun move() {
        if (pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }

    fun getDistance() = distance

    fun getName() = name
}