package racingcar.service.car

import org.junit.jupiter.api.Assertions
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
        Assertions.assertEquals(cars.cars.size, 3)
        Assertions.assertEquals(cars.cars[0].name.value, "pobi")
        Assertions.assertEquals(cars.cars[1].name.value, "woni")
        Assertions.assertEquals(cars.cars[2].name.value, "jun")
    }
}