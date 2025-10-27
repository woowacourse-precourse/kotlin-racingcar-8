package racingcar

import camp.nextstep.edu.missionutils.Randoms

class MoveRule {
    fun canMove(): Boolean {
        val number = Randoms.pickNumberInRange(0, 9)
        return number >= 4
    }
}