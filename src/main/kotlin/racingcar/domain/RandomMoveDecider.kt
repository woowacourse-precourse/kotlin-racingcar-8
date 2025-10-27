package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomMoveDecider : MoveDecider {
    override fun canMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD
    }

    private companion object {
        const val MOVE_THRESHOLD = 4
    }
}
