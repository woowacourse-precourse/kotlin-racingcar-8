package racingcar.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameExceptionTest {
    private lateinit var game: RacingGame

    @BeforeEach
    fun setUp() {
        game = RacingGame()
    }

    @Test
    @DisplayName("자동차는 이름은 5자를 넘어선 안된다")
    fun carNameShouldNotExceedMaxLength() {
        assertThrows<IllegalArgumentException> {
            game.setup("pobi,javaji", "1")
        }
    }

    @Test
    @DisplayName("자동차는 이름을 가져야 한다")
    fun carShouldHaveAName() {
        assertThrows<IllegalArgumentException> {
            game.setup("pobi,,woni", "1")
        }
    }

    @Test
    @DisplayName("자동차 수는 1대 이상이어야 한다")
    fun carShouldBeMoreThanOne() {
        assertThrows<IllegalArgumentException> {
            game.setup("pobi", "1")
        }
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외가 발생한다")
    fun roundShouldBeANumber() {
        assertThrows<IllegalArgumentException> {
            game.setup("pobi,woni", "abc")
        }
    }

    @Test
    @DisplayName("시도 횟수가 0보다 커야 한다")
    fun roundShouldBeLargerThanZero() {
        assertThrows<IllegalArgumentException> {
            game.setup("pobi,woni", "0")
        }
    }
}
