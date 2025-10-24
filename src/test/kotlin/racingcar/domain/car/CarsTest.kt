package racingcar.domain.car

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class CarsTest {

    @Test
    fun Car_리스트를_입력하면_Cars_객체가_생성된다() {
        // given
        val input = listOf(
            Car.from("pobi"),
            Car.from("woni"),
            Car.from("jun")
        )

        // when
        val cars = Cars.of(input)

        // then
        assertEquals(cars.cars.size, 3)
    }

    @Test
    fun Cars를_거리_기준_내림차순으로_올바르게_정렬한다() {
        // given
        val cars = Cars.of(listOf(
            Car.from("pobi"),
            Car.from("woni"),
            Car.from("jun")
        ))
        repeat(3) {
            cars.cars[0].move()
        }
        repeat(5) {
            cars.cars[1].move()
        }
        repeat(4) {
            cars.cars[2].move()
        }

        // when
        val sortedCars = cars.sortedByDistanceDesc()

        // then
        assertEquals(sortedCars.cars[0].name.value, "woni")
        assertEquals(sortedCars.cars[1].name.value, "jun")
        assertEquals(sortedCars.cars[2].name.value, "pobi")
    }
}