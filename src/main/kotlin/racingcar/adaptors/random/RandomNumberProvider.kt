package racingcar.adaptors.random

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.port.NumberProvider

class RandomNumberProvider : NumberProvider {
    override fun generateNumbers(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}