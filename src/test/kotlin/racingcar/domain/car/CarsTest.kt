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
            Car(Name("pobi")),
            Car(Name("woni")),
            Car(Name("jun"))
        )

        // when
        val cars = Cars(input)

        // then
        assertEquals(cars.cars.size, 3)
    }

    @Test
    fun 우승자를_성공적으로_반환한다() {
        // given
        val cars = Cars(listOf(
            Car(Name("pobi")),
            Car(Name("woni")),
            Car(Name("jun"))
        ))
        repeat(3) {
            cars.cars[0].move()
        }
        repeat(5) {
            cars.cars[1].move()
        }
        repeat(5) {
            cars.cars[2].move()
        }

        // when
        val winners = cars.getWinners()

        // then
        assertEquals(winners, "woni, jun")
    }
}