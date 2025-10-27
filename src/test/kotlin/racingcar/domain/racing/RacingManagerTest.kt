package racingcar.domain.racing

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class RacingManagerTest {

    @Test
    fun 자동차를_이동할_수_있는_경우_True를_반환한다() {
        // given
        val input = 4

        // when
        val canMove = RacingManager.canMove(input)

        // then
        assertTrue(canMove)
    }
}