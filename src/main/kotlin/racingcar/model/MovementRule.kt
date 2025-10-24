package racingcar.model

import racingcar.RacingCarConstants

class MovementRule() {
    fun hasMoveAndStop(randomNumber: Int): Boolean {
        val moveNumber = RacingCarConstants.MOVE_NUMBER
        return randomNumber >= moveNumber
    }
}