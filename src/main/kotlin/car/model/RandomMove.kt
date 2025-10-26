package car.model

import camp.nextstep.edu.missionutils.Randoms

// 무작위로 움직임을 결정하는 전략 구현체
class RandomMove : MoveStrategy {
    override fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}
