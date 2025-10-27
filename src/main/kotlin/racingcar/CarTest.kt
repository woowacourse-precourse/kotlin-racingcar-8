package racingcar

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `이름이 비어 있으면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("")
        }
    }

    @Test
    fun `이름이 5자를 초과하면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("abcdef")
        }
    }
}
