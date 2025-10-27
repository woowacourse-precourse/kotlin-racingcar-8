package racingcar

class Car(
    val name: String,
    private var position: Int = 0
) {

    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: $name")
        }
    }

    fun getPosition(): Int {
        return position
    }
}
