package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun `랜덤 숫자가 4 이상이면 전진한다`() {
        val car = Car("pobi")
        car.tryMove(4)
        assertEquals(1, car.getPosition())
    }

    @Test
    fun `랜덤 숫자가 3 이하면 전진하지 않는다`() {
        val car = Car("pobi")
        car.tryMove(3)
        assertEquals(0, car.getPosition())
    }
}
