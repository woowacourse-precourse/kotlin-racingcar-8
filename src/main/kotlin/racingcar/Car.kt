package racingcar

class Car(val name: String) {

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_NAME_LENGTH = 1
        private const val MOVE_STANDARD = 4
        private const val NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 1자 이상, 5자 이하만 가능합니다."
    }

    var position: Int = 0
        private set

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { NAME_LENGTH_ERROR_MESSAGE }
    }

    fun move(number: Int) {
        if (number >= MOVE_STANDARD) {
            position += 1
        }
    }
}