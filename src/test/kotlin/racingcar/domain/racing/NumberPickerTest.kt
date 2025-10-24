package racingcar.domain.racing

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class NumberPickerTest {

    @Test
    fun 랜덤한_숫자를_성공적으로_반환한다() {
        // given
        val numberPicker = NumberPicker()

        // when
        val n = numberPicker.getRandomNumber()

        // then
        assertTrue(n in 0..9)
    }
}