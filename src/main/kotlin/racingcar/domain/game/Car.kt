package racingcar.domain.game

import racingcar.domain.port.NumberProvider
import racingcar.domain.rule.MoveRule

abstract class Car(open val name: String) {

    var position: Int = 0
        protected set  // ⬅️ 하위 클래스에서 증가 가능하도록

    fun race(numberProvider: NumberProvider, moveRule: MoveRule) {
        val baseLine = numberProvider.generateNumbers()
        if (moveRule.canMove(baseLine)) move()
    }

    protected abstract fun move()
}


