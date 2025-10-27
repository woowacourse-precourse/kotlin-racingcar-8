package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car

class CarTest {
    @Test
    fun `자동차 이름이 5자 초과이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car("123456")
        }
    }

    @Test
    fun `자동차 이름이 5자 이하이면 정상적으로 생성된다`() {
        assertDoesNotThrow {
            Car("1234")
        }
    }

    @Test
    fun `자동차 이름이 공백일 시 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @Test
    fun `난수가 4 이상일 시 전진한다`() {
        val car = Car("test")

        car.move(4)
        car.move(9)

        assertEquals(2, car.getCurrentDistance())
        assertEquals("--", car.getCurrentDistanceWithHyphen())
    }

    @Test
    fun `난수가 3 이하일 시 전진하지 않는다`() {
        val car = Car("test")

        car.move(0)
        car.move(3)

        assertEquals(0, car.getCurrentDistance())
        assertEquals("", car.getCurrentDistanceWithHyphen())
    }
}