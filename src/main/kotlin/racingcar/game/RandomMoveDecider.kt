package racingcar.game

import camp.nextstep.edu.missionutils.Randoms

class RandomMoveDecider : MoveDecider {
    companion object {
        private const val MIN_RANDOM_VALUE = 0
        private const val MAX_RANDOM_VALUE = 9
        private const val MOVE_THRESHOLD = 4
    }

    override fun shouldMove(): Boolean {
        val randomValue = generateRandomValue()
        return isMovingCondition(randomValue)
    }

    private fun generateRandomValue(): Int {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
    }

    private fun isMovingCondition(randomValue: Int): Boolean {
        return randomValue >= MOVE_THRESHOLD
    }
}