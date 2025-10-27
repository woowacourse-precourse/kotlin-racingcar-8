package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinnerResolverTest {

    @Test
    fun `가장 멀리 간 자동차가 한 대일 때 단독 우승`() {
        val a = Car("pobi")
        val b = Car("woni")
        a.tryMove(9) // pobi 전진
        val winners = WinnerResolver.resolveWinners(listOf(a, b))
        assertEquals(listOf("pobi"), winners)
    }

    @Test
    fun `같은 거리를 간 자동차가 여러 대면 공동 우승`() {
        val a = Car("pobi")
        val b = Car("woni")
        a.tryMove(8)
        b.tryMove(8)
        val winners = WinnerResolver.resolveWinners(listOf(a, b))
        assertEquals(listOf("pobi", "woni"), winners)
    }
}

class WinnerResolverEdgeCaseTest {

    @Test
    fun `아무도 이동하지 않은 경우 모든 자동차가 우승자다`() {
        val a = Car("pobi")
        val b = Car("woni")
        val c = Car("jun")

        // 모두 position 0
        val winners = WinnerResolver.resolveWinners(listOf(a, b, c))

        assertEquals(listOf("pobi", "woni", "jun"), winners)
    }
}

