package racingcar.io

import racingcar.main

import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputViewTest : NsTest() {
    @Test
    fun `printPosition 정상 출력`() {
        val testInputs = mapOf(
            Pair("pobi", 4),
            Pair("woni", 3),
            Pair("jun", 4),
        )

        for ((name, position) in testInputs) {
            OutputView.printPosition(name, position)
        }

        assertSimpleTest {
            run()
            assertThat(output()).contains("pobi : ----", "woni : ---", "jun : ----")
        }
    }

    // FAIL: TODO
    // : println의 끝 쪽 공백이 삭제되어 "pobi : "가 아닌 "pobi :" 값이 output()에 저장되어버리는 문제 발생
    // 지금 당장으로선 해결이 어려울 것으로 보이므로, 추후 해결 예정
    @Test
    fun `printPosition position이 0일 때 출력`() {
        val testInput = Pair("pobi", 0)

        OutputView.printPosition(testInput.first, testInput.second)

        assertSimpleTest {
            run()
            assertThat(output()).contains("pobi : ")
        }
    }

    @Test
    fun `printWinners 단일 우승자 정상 출력`() {
        val winners = listOf("pobi")
        OutputView.printWinners(winners)

        assertSimpleTest {
            assertThat(output()).contains("최종 우승자 : pobi")
        }
    }

    @Test
    fun `printWinners 복수 우승자 정상 출력`() {
        val winners = listOf("pobi", "jun")
        OutputView.printWinners(winners)

        assertSimpleTest {
            assertThat(output()).contains("최종 우승자 : pobi, jun")
        }
    }

    override fun runMain() {
        main()
    }
}