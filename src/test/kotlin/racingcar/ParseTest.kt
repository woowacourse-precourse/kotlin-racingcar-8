package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ParseTest {

    @Test
    fun ValidName(){
        val input = "pobi, woni, jun"
        val result = parse(input)
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun EmptyInput(){
        val input = ""
        assertThrows<IllegalArgumentException> { parse(input) }
    }

    @Test
    fun EmptyName(){
        val input = "pobi, , jun"
        assertThrows<IllegalArgumentException> { parse(input) }
    }

    @Test
    fun LongName(){
        val input = "pobi, woniwoni, jun"
        assertThrows<IllegalArgumentException> { parse(input) }
    }
}