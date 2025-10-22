package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumCheckTest {

    @Test
    fun validNum(){
        val input = "5"
        val result: Int = numCheck(input)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun notNum(){
        val input = "five"
        assertThrows<IllegalArgumentException> { numCheck(input) }
    }

    @Test
    fun notNumericNum(){
        val input = "-1"
        assertThrows<IllegalArgumentException> { numCheck(input) }
    }
}