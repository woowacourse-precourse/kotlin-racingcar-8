package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.util.Constants.ZERO

class Number {
    fun randomGenerator(): Int {
        return Randoms.pickNumberInRange(ZERO, 9)
    }
}