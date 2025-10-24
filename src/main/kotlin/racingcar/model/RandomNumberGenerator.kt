package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {
    fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(1, 9)
    }
}