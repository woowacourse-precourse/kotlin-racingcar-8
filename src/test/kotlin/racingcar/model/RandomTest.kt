package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.domain.Randoms

class RandomTest : NsTest() {

    private var actualResult: Boolean? = null

    @Test
    fun `전진`() {
        assertRandomNumberInRangeTest(
            {
                run()
                assertThat(actualResult).isTrue
            }, MOVING_FORWARD
        )
    }

    @Test
    fun `정지`() {
        assertRandomNumberInRangeTest(
            {
                run()
                assertThat(actualResult).isFalse
            }, STOP
        )
    }


    override fun runMain() {
        actualResult = Randoms.isAdvance()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}