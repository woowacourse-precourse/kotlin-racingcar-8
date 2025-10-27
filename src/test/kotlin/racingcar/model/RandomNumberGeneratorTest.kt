package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {

    @Test
    fun `generate number between 0 and 9`() {
        val numberGenerator = RandomNumberGenerator()

        val generateNumber = numberGenerator.generate()

        assertThat(generateNumber).isBetween(0, 9)
    }
}