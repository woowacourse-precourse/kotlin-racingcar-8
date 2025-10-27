package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomUtils {
    fun getRandomInt(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}