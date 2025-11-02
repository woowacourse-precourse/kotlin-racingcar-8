package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String, // 자동차 이름
    var position: Int = 0 // 자동차의 이동 횟수
) {
    // 자동차 이름 유효성 검증
    init {
        require(name.isNotBlank()) { "자동차 이름을 입력해주세요!" }
        require(name.length <= 5) { "자동차 이름은 5자 이하만 가능합니다." }
    }

    fun move() {
        val random = Randoms.pickNumberInRange(0, 9)
        if (random >= 4)
            position++
    }
}