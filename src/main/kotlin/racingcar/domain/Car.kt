package racingcar.domain

import racingcar.util.RandomGenerator

class Car {
    private var position: Int
    val name: String
    val positionValue: Int
        get() = position

    constructor(name: String, position: Int = 0) {
        this.position = position
        this.name = Validator.validateCarName(name)
    }

    /**
     * 매 턴마다 전진을 시도한다.
     *
     * @param isOverThreshold 테스트 편의성을 위해 외부에서 전달받는 랜덤 값
     */
    fun tryMove(isOverThreshold: Boolean = RandomGenerator.isNotLessThanThreshold()) {
        position += if (isOverThreshold) 1 else 0
    }
}