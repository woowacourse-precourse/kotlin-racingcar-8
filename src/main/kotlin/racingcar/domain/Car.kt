package racingcar.domain

class Car(private val name: String) {
    private var position = 0

    fun moveForward() {
        position++
    }

    fun getName(): String {
        return name
    }

    fun getPosition(): Int {
        return position
    }
}