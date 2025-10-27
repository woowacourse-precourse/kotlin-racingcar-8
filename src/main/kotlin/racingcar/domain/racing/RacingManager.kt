package racingcar.domain.racing

object RacingManager {
    private const val THRESHOLD: Int = 4

    fun canMove(n: Int): Boolean {
        return n >= THRESHOLD
    }
}