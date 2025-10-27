package racingcar.domain

class Car(val name: String, private var position: Int = 0) {

    fun move(randomValue: Int) {
        if (randomValue >= MOVE_THRESHOLD) {
            position++
        }
    }

    fun getPosition(): Int = position

    companion object {
        private const val MOVE_THRESHOLD = 4
    }
}