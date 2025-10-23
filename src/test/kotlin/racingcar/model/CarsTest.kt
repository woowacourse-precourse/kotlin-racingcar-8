package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `리스트로 Car 생성하기`() {
        val carNames = mutableListOf<String>("A", "B", "C")
        val cars = mutableListOf<Car>(Car("A"), Car("B"), Car("C"))

        assertEquals(cars, Cars().createCar(carNames))
    }
}