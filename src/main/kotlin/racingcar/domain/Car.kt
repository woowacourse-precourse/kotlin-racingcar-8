package racingcar.domain

data class Car(val name: String, val position: Int = 0) {
    fun move(strategy: MoveStrategy): Car {
        if (strategy.canMove()) {
            return this.copy(position = position + 1)
        }
        return this
    }

    fun getPositionString(): String = "-".repeat(position)
}
