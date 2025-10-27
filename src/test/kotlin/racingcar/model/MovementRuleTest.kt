package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MovementRuleTest {
    @Test
    fun `랜덤 숫자가 4 이상이면 true`() {
        val fakeGenerator = FakeRandomNumberGenerator(listOf(4))
        val rule = MovementRule(fakeGenerator)
        val result = rule.hasMoveAndStop()

        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `랜덤 숫자가 3 이하면 false`() {
        val fakeGenerator = FakeRandomNumberGenerator(listOf(3))
        val rule = MovementRule(fakeGenerator)
        val result = rule.hasMoveAndStop()

        assertThat(result).isEqualTo(false)
    }
}