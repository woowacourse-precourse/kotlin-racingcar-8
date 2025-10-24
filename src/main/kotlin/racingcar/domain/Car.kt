package racingcar.domain

import racingcar.util.RandomGenerator

class Car(
    name: String,
    position: Int = 0
) {
    val name: String = Validator.validateCarName(name)
    var position: Int = position
        private set


    /** [isOverThreshold]가 true일 경우 전진한다. */
    fun tryMove(isOverThreshold: Boolean = RandomGenerator.isNotLessThanThreshold()) {
        if (isOverThreshold) position++
    }
}