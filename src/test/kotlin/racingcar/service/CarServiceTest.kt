package racingcar.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class CarServiceTest {

    private val carService = CarService()

    @Test
    fun 입력값으로_Cars_객체를_성공적으로_생성한다() {
        // given
        val input = "pobi,woni , jun"

        // when
        val cars = carService.createCars(input)

        // then
        assertEquals(cars.cars.size, 3)
        assertEquals(cars.cars[0].name.value, "pobi")
        assertEquals(cars.cars[1].name.value, "woni")
        assertEquals(cars.cars[2].name.value, "jun")
    }
}