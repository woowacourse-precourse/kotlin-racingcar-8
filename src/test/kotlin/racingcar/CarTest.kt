package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @Test
    fun `자동차 이름은 한 글자 이상을 포함해야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car.withStartPosition("") }
        }
    }

    @Test
    fun `자동차 이름은 5글자 이하여야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car.withStartPosition("123456") }
        }
    }

    @Test
    fun `자동차 이름은 중복을 허용하지 않는다`() {
        assertSimpleTest {
            val names = listOf("A", "A")
            assertThrows<IllegalArgumentException> { Round.startWith(names) }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["\n", "\t", " ", "''", "\"", "\\", "``", "wo\ni!"])
    fun `자동차 이름은 다양한 특수문자를 허용한다`(specialName: String) {
        assertSimpleTest {
            assertDoesNotThrow { Car.withStartPosition(specialName) }
        }
    }

    @Test
    fun `자동차 위치는 0미만일 수 없다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car("pobi", -1) }
        }
    }
}