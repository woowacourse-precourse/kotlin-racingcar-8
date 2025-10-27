package racingcar.model.domain

class Car(val name: String, var position: Int = 0) {
    fun move() {
        position++;
    }
}