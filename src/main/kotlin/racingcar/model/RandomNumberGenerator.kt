package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

interface NumberGenerator {
    fun getRandomNumber(): Int
}

class RandomNumberGenerator: NumberGenerator {
    override fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(1, 9)
    }
}