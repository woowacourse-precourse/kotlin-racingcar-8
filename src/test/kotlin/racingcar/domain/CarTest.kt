package racingcar.domain

import racingcar.main
import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.util.RandomGenerator

class CarTest : NsTest() {
    @Test
    fun `주입된 랜덤값에 따라 이동 여부 결정`() {
        val car = Car("pobi")

        val successCount = 2
        repeat(successCount) { car.tryMove(true) }

        val failureCount = 2
        repeat(failureCount) { car.tryMove(false) }

        val lastPosition = car.positionValue
        assertThat(lastPosition).isEqualTo(successCount)
    }

    @Test
    fun `RandomGenerator 결과값에 따라 이동 누적`() {
        val car = Car("pobi")

        assertRandomNumberInRangeTest(
            {
                repeat(TEST_COUNT) { car.tryMove() }
            },
            TEST_VALUE, *RANDOM_TEST_VALUES
        )

        val expectedValue = car.positionValue
        val actualValue = RANDOM_TEST_VALUES.plus(TEST_VALUE).count { it >= RandomGenerator.THRESHOLD }
        assertThat(expectedValue).isEqualTo(actualValue)
    }

    override fun runMain() {
        main()
    }

    companion object {
        const val TEST_VALUE = 4
        val RANDOM_TEST_VALUES = arrayOf(5, 3, 8)
        val TEST_COUNT = RANDOM_TEST_VALUES.count() + 1
    }
}