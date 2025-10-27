package racingcar.domain.rule

interface MoveRule {
    fun canMove(range: Int): Boolean
}