package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class OutputTest : NsTest() {
    @Test
    fun `printOutput 기능 테스트`() {
        // given
        val winners = listOf<Car>(Car("pobi"), Car("woni"))

        // when
        printOutput(winners)

        // then
        assertThat(output()).contains("최종 우승자 : pobi, woni")
    }

    override fun runMain() {
    }
}