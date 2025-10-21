package racingcar

import camp.nextstep.edu.missionutils.Randoms

// 자동차 모델
class Car(val name: String) {
    var moves: Int = 0

    fun moving() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moves += 1
        }
    }
}