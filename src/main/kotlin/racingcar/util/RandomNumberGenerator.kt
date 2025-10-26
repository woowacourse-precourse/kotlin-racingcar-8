package racingcar.util

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.NumberGenerator

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
    }
}