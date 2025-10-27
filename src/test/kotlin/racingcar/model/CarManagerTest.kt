package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class CarManagerTest {

    private val failureGenerator = FixedNumberGenerator(3)
    private val successGenerator = FixedNumberGenerator(5)

    @Test
    fun add_car_to_gameBoard() {
        val carManager = CarManager(RandomNumberGenerator())
        val cars = listOf("pobi", "woni", "jun")

        carManager.addCar(cars)

        assertEquals(0, carManager.getCarLocation("pobi"))
        assertEquals(0, carManager.getCarLocation("woni"))
        assertEquals(0, carManager.getCarLocation("jun"))
    }

    @Test
    fun addCar_handlesEmptyList() {
        val carManager = CarManager(RandomNumberGenerator())
        val emptyList = emptyList<String>()

        carManager.addCar(emptyList)
    }

    @Test
    fun getCarLocationTest() {
        val carManager = CarManager(RandomNumberGenerator())
        val cars = listOf("woni")
        carManager.addCar(cars)
        val carLocation = carManager.getCarLocation("woni")
        assertEquals(carLocation, 0)
    }

    @Test
    fun moveCar_Success() {
        val carManager = CarManager(successGenerator)
        val carName = "jun"
        carManager.addCar(listOf(carName))

        carManager.moveCar(carName)

        assertEquals(1, carManager.getCarLocation(carName))
    }

    @Test
    fun moveCar_Failure() {
        val carManager = CarManager(failureGenerator)
        val carName = "jun"
        carManager.addCar(listOf(carName))

        carManager.moveCar(carName)

        assertEquals(0, carManager.getCarLocation(carName))
    }

    @Test
    fun returnResultTest() {
        val carManager = CarManager(successGenerator)
        val cars = listOf("pobi", "woni", "jun")
        carManager.addCar(cars)
        carManager.moveCar("pobi")
        carManager.moveCar("woni")
        carManager.moveCar("jun")
        carManager.moveCar("jun")
        carManager.moveCar("pobi")
        carManager.moveCar("pobi")

        val returnResult = carManager.returnResult()

        assertThat(returnResult).isEqualTo(listOf("pobi"))
    }

    @Test
    fun returnResult_can_joint_winner() {
        val carManager = CarManager(successGenerator)
        val cars = listOf("pobi", "woni", "jun")
        carManager.addCar(cars)
        carManager.moveCar("pobi")
        carManager.moveCar("woni")
        carManager.moveCar("jun")
        carManager.moveCar("jun")
        carManager.moveCar("jun")
        carManager.moveCar("pobi")
        carManager.moveCar("pobi")

        val returnResult = carManager.returnResult()

        assertThat(returnResult).isEqualTo(listOf("pobi", "jun"))
    }
}