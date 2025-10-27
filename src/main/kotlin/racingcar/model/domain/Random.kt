package racingcar.model.domain

import racingcar.model.repository.RandomRule
import camp.nextstep.edu.missionutils.Randoms

object Randoms : RandomRule {
    override fun isAdvance(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}