package racingcar.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class WinnerCalculatorTest {

    @Test
    fun `가장 많이 이동한 자동차가 우승한다`() {
        val pobi = Car("pobi")
        val woni = Car("woni")
        repeat(3) { pobi.move() }
        repeat(1) { woni.move() }

        val winners = WinnerCalculator.calculate(listOf(pobi, woni))
        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `공동 우승자가 있을 경우 둘 다 출력된다`() {
        val pobi = Car("pobi")
        val jun = Car("jun")
        repeat(2) { pobi.move() }
        repeat(2) { jun.move() }

        val winners = WinnerCalculator.calculate(listOf(pobi, jun))
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun")
    }
}
