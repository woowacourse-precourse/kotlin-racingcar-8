package car.model

import camp.nextstep.edu.missionutils.Randoms

class RandomMove : MoveStrategy {
    override fun RandomNumber(): Boolean {
        Randoms.pickNumberInRange(0, 9)
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}
