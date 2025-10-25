package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position = 0
        private set
    init {
        require(name.isNotEmpty()) { "자동차 이름은 비어있을 수 없습니다." }
        require(name.length <= 5) { "자동차 이름은 5자 이하만 가능합니다." }
    }

    fun move() {
        if (isMovable()) position++
    }

    private fun isMovable(): Boolean {
        val number = Randoms.pickNumberInRange(0, 9)
        return number >= 4
    }
}
