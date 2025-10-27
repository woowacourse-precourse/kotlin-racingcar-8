package racingcar.domain

data class Car(val name: String) {
    var position = 0
        internal set

    fun move(randomInt: Int) {
        if (randomInt >= 4) {
            position++
        }
    }
}