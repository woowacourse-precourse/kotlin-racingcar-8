package racingcar

data class Car(
    val name: String,
    var position: Int = 0
) {
    fun move(rule: MoveRule) {
        if (rule.canMove()) position++
    }

    fun carStatus(): String = "$name : ${"-".repeat(position)}"
}