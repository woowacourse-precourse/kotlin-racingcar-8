package racingcar.io

import racingcar.main

import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import racingcar.domain.Car

class OutputViewTest : NsTest() {
    @Test
    fun `printCarStatus 정상 출력`() {
        val testInputs = listOf(
            Car("pobi", 4),
            Car("woni", 3),
            Car("jun", 4),
        )

        for (car in testInputs) {
            OutputView.printCarStatus(car)
        }

        assertSimpleTest {
            run()
            assertThat(output()).contains("pobi : ----", "woni : ---", "jun : ----")
        }
    }

    @Test
    @Disabled("output() 구현부에 trim() 메서드가 포함되어 있어, assertThat의 결과가 부정확함")
    fun `printCarStatus position이 0일 때 출력`() {
        val testInput = Car("pobi", 0)

        OutputView.printCarStatus(testInput)

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