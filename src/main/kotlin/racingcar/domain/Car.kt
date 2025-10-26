package racingcar.domain

class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        require(name.isNotBlank()) { "자동차 이름은 비어 있을 수 없습니다." }
        require(name.length <= 5) { "자동차 이름은 5자 이하여야 합니다." }
    }

    fun move(number: Int) {
        if (number >= 4) {
            position += 1
        }
    }

    fun getStatus(): String {
        return "$name : ${"-".repeat(position)}"
    }
}
