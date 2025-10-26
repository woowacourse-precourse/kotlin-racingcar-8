package racingcar.domain.game

class Car(name: String) {
    var position = 0
        private set
    var name = name
        private set

    fun race(numberProvider: NumberProvider, moveRule: MoveRule) {
        val baseLine = numberProvider.generateNumbers()
        if (moveRule.canMove(baseLine))
            move()
    }

    private fun move() {
        position++
    }

    override fun toString(): String {
        return name + " : " + "-".repeat(position)
    }

}