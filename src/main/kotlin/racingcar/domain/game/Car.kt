package racingcar.domain.game

class Car(private val name: String) {
    private var position = 0

    fun race(numberProvider: NumberProvider, moveRule: MoveRule) {
        val baseLine = numberProvider.generateNumbers()
        if (moveRule.canMove(baseLine))
            move()
        stop()
    }

    private fun move() {
        position++
        return
    }

    private fun stop() {
        return
    }

    override fun toString(): String {
        return name + " : " + "-".repeat(position);
    }

}