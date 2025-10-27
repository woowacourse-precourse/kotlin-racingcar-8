package racingcar.model

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return pickNumberInRange(0, 9)
    }
}