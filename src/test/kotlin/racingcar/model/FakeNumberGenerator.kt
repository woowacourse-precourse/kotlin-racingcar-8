package racingcar.model

import racingcar.util.NumberGenerator

class FakeNumberGenerator(
    private val numbersToReturn: List<Int>,
) : NumberGenerator {
    private var index = 0

    override fun generateNumber(): Int = numbersToReturn[index++]
}
