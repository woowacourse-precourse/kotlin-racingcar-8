package racingcar

data class Car(val name: String, val position: Int) {
    init {
        require(name.isNotEmpty()) { "자동차 이름은 한 글자 이상을 포함해야 합니다." }
        require(name.length <= NAME_LENGTH_LIMIT) { "자동차 이름은 5글자 이하여야 합니다." }
    }

    init {
        require(position >= START_POSITION) {
            "자동차의 위치($position)는 $START_POSITION 미만일 수 없습니다."
        }
    }

    fun moveForward(): Car = Car(name, position + MOVE_INCREMENT)
    fun tryMoveForward(number: Int): Car {
        if (number >= MOVING_THRESHOLD) {
            return moveForward()
        }
        return this
    }

    companion object {
        const val START_POSITION = 0
        const val NAME_LENGTH_LIMIT = 5
        const val MOVE_INCREMENT = 1
        const val MOVING_THRESHOLD = 4

        fun withStartPosition(name: String): Car = Car(name, START_POSITION)
    }
}