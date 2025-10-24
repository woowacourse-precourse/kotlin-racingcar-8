package racingcar.model

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class Car(private val name: String) {
    private var distance: Int = 0

    init {
        require(name.isNotEmpty()) { "이름은 비어 있을 수 없습니다." }
        require(name.length <= MAX_NAME_LENGTH) { "이름은 5자 이하여야 합니다." }
    }

    fun move() {
        if (pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }

    override fun toString(): String {
        return "$name : ${"*".repeat(distance)}"
    }

    fun getDistance(): Int {
        return distance
    }

    fun getName(): String {
        return name
    }

    companion object {
        const val MAX_NAME_LENGTH = 5;
    }

}