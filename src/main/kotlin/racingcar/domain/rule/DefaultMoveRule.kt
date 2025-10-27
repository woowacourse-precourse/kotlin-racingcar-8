package racingcar.domain.rule

class DefaultMoveRule : MoveRule {
    override fun canMove(number: Int): Boolean {
        return number >= MIN_RANDOM_TO_MOVE
    }

    companion object {
        private const val MIN_RANDOM_TO_MOVE = 4
    }

}