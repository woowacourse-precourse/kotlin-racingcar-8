package racingcar.domain

class Car(val name: String) {
    var position = 0
        private set

    fun move(randomInt: Int) {
        if (randomInt >= 4) {
            position++
        }
    }
}