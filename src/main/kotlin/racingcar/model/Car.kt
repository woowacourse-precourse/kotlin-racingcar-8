package racingcar.model

data class Car(
    val name: String,
    val position: Int = 0,
) {
    private val threshold = 4

    fun move(randomNumber: Int): Car {
        if (randomNumber >= threshold) {
            return this.copy(position = position + 1)
        }
        return this
    }
}
