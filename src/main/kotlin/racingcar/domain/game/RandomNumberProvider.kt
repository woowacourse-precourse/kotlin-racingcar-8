package racingcar.domain.game

import camp.nextstep.edu.missionutils.Randoms


class RandomNumberProvider : NumberProvider {
    override fun generateNumbers(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}