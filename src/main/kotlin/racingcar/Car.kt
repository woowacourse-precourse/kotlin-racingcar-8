package racingcar

class Car(
    val name: String,
    var position: Int = 0
) {
    companion object {
        private const val MOVEMENT_TRESHOLD = 4
    }

    fun moveForward(randomNumber: Int) {
        if (randomNumber >= MOVEMENT_TRESHOLD) {
            this.position++
        }
    }
}