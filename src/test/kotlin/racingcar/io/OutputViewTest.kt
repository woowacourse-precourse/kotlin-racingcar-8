package racingcar.io

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
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

    @Test
    fun `printRounds 출력 테스트(하드코딩)`() {
        val cars1 = listOf(Car("pobi", 1), Car("woni", 0))
        val cars2 = listOf(Car("pobi", 2), Car("woni", 1))
        val rounds = sequenceOf(cars1, cars2)

        OutputView.printRounds(rounds)

        val expected = """
            pobi : -
            woni : 
            
            pobi : --
            woni : -""".trimIndent()

        assertSimpleTest {
            assertThat(output()).isEqualTo(expected)
        }
    }

    override fun runMain() {}
}