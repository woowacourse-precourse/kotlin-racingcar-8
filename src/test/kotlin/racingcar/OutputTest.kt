package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.view.OutputView

class OutputTest : NsTest() {

    @Test
    fun `실행 결과 타이틀 출력`() {
        assertSimpleTest {
            OutputView.displayTitle()
            assertThat(output()).contains("실행 결과")
        }
    }

    @Test
    fun `라운드별 실행 결과 출력`() {
        val result = mapOf(
            "pobi" to 1,
            "woni" to 0,
            "jun" to 2
        )
        assertSimpleTest {
            OutputView.displayRoundResult(result)
            assertThat(output()).contains("pobi : -", "woni : ", "jun : --")
        }
    }

    @Test
    fun `우승자 1명 출력`() {
        val winner = listOf("pobi")
        assertSimpleTest {
            OutputView.displayWinners(winner)
            assertThat(output()).contains("최종 우승자 : pobi")
        }
    }

    @Test
    fun `우승자가 여러명일 경우 쉼표로 구분하여 출력`() {
        val winners = listOf("pobi", "woni")
        assertSimpleTest {
            OutputView.displayWinners(winners)
            assertThat(output()).contains("최종 우승자 : pobi, woni")
        }
    }

    override fun runMain() {
        main()
    }
}