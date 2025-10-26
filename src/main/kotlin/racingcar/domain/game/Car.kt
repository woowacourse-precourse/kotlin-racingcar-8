package racingcar.domain.game

class Car(private val name: String) {
    private var _position = 0
    val position: Int get() = _position

    fun race(numberProvider: NumberProvider, moveRule: MoveRule) {
        val baseLine = numberProvider.generateNumbers()
        if (moveRule.canMove(baseLine))
            move()
    }

    private fun move() {
        _position++
        return
    }

    override fun toString(): String {
        return name + " : " + "-".repeat(position)
    }

}