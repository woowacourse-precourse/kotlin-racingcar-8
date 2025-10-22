package racingcar.domain

import racingcar.util.RandomGenerator

data class Car(
    val name: String,
    private var position: Int = 0
) {
    private fun increasePosition() {
        position += 1
    }

    /**
     * 매 턴마다 전진을 시도한다.
     *
     * @param randomValue Test 편의성을 위해 외부에서 랜덤값을 주입 받는다.
     */
    fun tryMove(randomValue: Boolean = RandomGenerator.isNotLessThanThreshold()) {
        if (randomValue) increasePosition()
    }

    fun getPosition() = position
}