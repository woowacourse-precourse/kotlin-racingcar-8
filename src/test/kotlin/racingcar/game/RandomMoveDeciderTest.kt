package racingcar.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomMoveDeciderTest {

    @Test
    fun `MoveDecider는 불린값을 반환한다`() {
        // given
        val moveDecider = RandomMoveDecider()

        // when
        val result = moveDecider.shouldMove()

        // then
        assertThat(result).isIn(true, false)
    }

    @Test
    fun `여러 번 호출해도 정상적으로 동작한다`() {
        // given
        val moveDecider = RandomMoveDecider()

        // when & then
        repeat(10) {
            val result = moveDecider.shouldMove()
            assertThat(result).isIn(true, false)
        }
    }
}