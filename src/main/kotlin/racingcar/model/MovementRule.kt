package racingcar.model

class MovementRule(
    private val randomNumberGenerator: NumberGenerator
) {
    companion object {
        private const val MOVE_NUMBER = 4

    }
    fun hasMoveAndStop(): Boolean {
        return randomNumberGenerator.getRandomNumber() >= MOVE_NUMBER
    }
}