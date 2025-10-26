package racingcar.model

import racingcar.RacingCarConstants

class MovementRule(
    private val randomNumberGenerator: NumberGenerator
) {
    fun hasMoveAndStop(): Boolean {
        val moveNumber = RacingCarConstants.MOVE_NUMBER
        return randomNumberGenerator.getRandomNumber() >= moveNumber
    }
}