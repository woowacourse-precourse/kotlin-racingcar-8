package car.model

import camp.nextstep.edu.missionutils.Randoms

class RandomMove : MoveStrategy {
    override fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}
