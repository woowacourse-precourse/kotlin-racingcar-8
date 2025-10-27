package racingcar.model

data class Car(val name: String, var distance: Int = 0) {

    companion object {
        const val MAX_NAME_LENGTH = 5
        const val MIN_MOVE_NUMBER = 4
    }

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 ${MAX_NAME_LENGTH}자 이하만 가능합니다." }
        require(name.isNotEmpty()) { "자동차 이름은 1자 이상 작성해야 합니다." }
    }

    fun move(generatedRandomNumber: Int) {
        if (generatedRandomNumber >= MIN_MOVE_NUMBER) {
            distance++
        }
    }
    fun getDistance(): Int = distance
    fun getDistanceWithHyphen(): String = "-".repeat(distance)
}
