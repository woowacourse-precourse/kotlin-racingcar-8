package racingcar.util

import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RandomGeneratorTest : NsTest() {

    @Test
    fun `isNotLessThanThreshold 정상범위 테스트`() {
        assertRandomNumberInRangeTest({
            TESTS.forEach { value ->
                val result = RandomGenerator.isNotLessThanThreshold()
                assertThat(result).isEqualTo(value > THRESHOLD)
            }
        }, MIN, *TESTS)
    }

    override fun runMain() {}

    companion object {
        const val MIN = RandomGenerator.MIN_VALUE
        const val MAX = RandomGenerator.MAX_VALUE
        const val THRESHOLD = RandomGenerator.THRESHOLD
        val TESTS: Array<Int> = (MIN+1..MAX).toList().toTypedArray()
    }
}