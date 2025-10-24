package racingcar.domain

class Car(name: String) {
    var distance: Int = INITIAL_CAR_DISTANCE
    init {
        require(name.length < MAX_NAME_LENGTH) { "자동차 이름의 길이는 5자 이하여야 합니다" }
        require(!name.contains(" ")) { "자동차 이름엔 공백이 포함되면 안됩니다" }
    }

    fun moveForward() {
        val randomNumber = RandomNumberGenerator().generateNumber()
        if(randomNumber >= MOVE_FORWARD_CONDITION_NUMBER) {
            distance++
        }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val INITIAL_CAR_DISTANCE = 0
        private const val MOVE_FORWARD_CONDITION_NUMBER = 4
    }
}