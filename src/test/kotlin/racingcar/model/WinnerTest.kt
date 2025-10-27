package racingcar.model

import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.domain.Winner

class WinnerTest : NsTest() {

    private var actualResult: List<Int>? = null

    @Test
    fun `우승자 선발`() {
        assertSimpleTest(
            {
                run("2", "1")
                assertThat(actualResult).isEqualTo(listOf(0))
            })
    }

    @Test
    fun `중복 우승자 선발`() {
        assertSimpleTest(
            {
                run("2", "2")
                assertThat(actualResult).isEqualTo(listOf(0, 1))
            })
    }


    override fun runMain() {
        val input1 = Console.readLine().toInt()
        val input2 = Console.readLine().toInt()

        actualResult = Winner.find(listOf(input1, input2));
    }
}