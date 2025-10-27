package racingcar

data class Car(
    val name: String,
    private var position: Int = 0
) {
    fun move(randomValue: Int) {
        if (randomValue >= FORWARD_THRESHOLD) {
            position++
        }
    }

    fun getPosition(): Int = position
    fun getPositionDisplay(): String = POSITION_MARKER.repeat(position)

    companion object {
        private const val FORWARD_THRESHOLD = 4
        private const val POSITION_MARKER = "-"
    }
}






