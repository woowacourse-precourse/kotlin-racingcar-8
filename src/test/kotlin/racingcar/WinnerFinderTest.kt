package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class WinnerFinderTest {

    @Test
    fun `단독 우승자`() {
        val a = Car("pobi").apply { repeat(3) { positionPlus1() } }
        val b = Car("woni").apply { repeat(1) { positionPlus1() } }
        val c = Car("jun")
        val winners = WinnerFinder.findWinners(listOf(a, b, c))
        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `공동 우승자는 입력 순서 유지`() {
        val a = Car("pobi").apply { repeat(2) { positionPlus1() } }
        val b = Car("woni").apply { repeat(2) { positionPlus1() } }
        val c = Car("jun")
        val winners = WinnerFinder.findWinners(listOf(a, b, c))
        assertThat(winners).containsExactly("pobi", "woni")
    }

    // 편의용 확장: 테스트 내부에서만 사용
    private fun Car.positionPlus1() {
        val field = Car::class.java.getDeclaredField("position")
        field.isAccessible = true
        field.setInt(this, field.getInt(this) + 1)
    }
}
