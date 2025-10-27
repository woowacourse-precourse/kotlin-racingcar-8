package racingcar

class Car (
    val name: String,
    private var position: Int = 0
) {
    fun getPosition(): Int {
        return position
    }
}