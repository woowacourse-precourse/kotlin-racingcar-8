package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `리스트로 Car 생성하기`() {
        val carNames = mutableListOf<String>("A", "B", "C")
        val cars = mutableListOf<Car>(Car("A"), Car("B"), Car("C"))
        assertEquals(cars, Cars().createCar(carNames))
    }

    @Test
    fun `레이싱 진행 후 차 위치 확인`() {
        val cars = Cars()
        cars.createCar(listOf("A", "B", "C"))
        cars.startRound()

        val carList = cars.getCars()

        carList.forEach {
            assertTrue(it.position >= 0)
            println("${it.name}의 위치 : ${it.position}")
        }
    }
}