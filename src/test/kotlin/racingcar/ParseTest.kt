package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ParseTest {

    @Test
    fun validName(){
        val input = "pobi, woni, jun"
        val result = parse(input)
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun emptyInput(){
        val input = ""
        assertThrows<IllegalArgumentException> { parse(input) }
    }

    @Test
    fun emptyName(){
        val input = "pobi, , jun"
        assertThrows<IllegalArgumentException> { parse(input) }
    }

    @Test
    fun longName(){
        val input = "pobi, woniwoni, jun"
        assertThrows<IllegalArgumentException> { parse(input) }
    }
}