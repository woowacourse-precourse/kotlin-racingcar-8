package racingcar.model

data class Car(
    val carName: String,
    val position: Int = INITIAL_POSITION
) {
    fun move(randomValue: Int): Car {
        return if (randomValue >= MOVE_FORWARD_THRESHOLD) {
            copy(position = position + MOVE_DISTANCE)
        } else this
    }

    companion object {
        const val MAX_CAR_NAME_LENGTH = 5
        const val INITIAL_POSITION = 0
        const val MOVE_FORWARD_THRESHOLD = 4
        const val MOVE_DISTANCE = 1
    }
}