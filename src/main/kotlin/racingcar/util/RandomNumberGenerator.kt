package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(): Int = Randoms.pickNumberInRange(0, 9)
}
