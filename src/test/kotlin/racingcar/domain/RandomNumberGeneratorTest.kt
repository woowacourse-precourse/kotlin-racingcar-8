package racingcar.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {
    @Test
    fun `0부터 9까지 랜덤한 수를 생성한다`() {
        // given & when
        val randomNumber = RandomNumberGenerator().generateNumber()
        // then
        assertTrue(randomNumber in 0..9)
    }
}