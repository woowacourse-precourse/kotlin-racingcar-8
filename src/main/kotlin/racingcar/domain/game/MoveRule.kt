package racingcar.domain.game

interface MoveRule {
    fun canMove(number: Int): Boolean
}