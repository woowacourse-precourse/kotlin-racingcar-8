package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(): Int = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER)

    companion object {
        const val RANDOM_MIN_NUMBER = 0
        const val RANDOM_MAX_NUMBER = 9
    }
}