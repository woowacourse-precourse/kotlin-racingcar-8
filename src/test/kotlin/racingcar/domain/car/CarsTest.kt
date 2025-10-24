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
        val input = mutableListOf(
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
    fun Cars를_거리_기준_내림차순으로_올바르게_정렬한다() {
        // given
        val cars = Cars(mutableListOf(
            Car(Name("pobi"), 3),
            Car(Name("woni"), 5),
            Car(Name("jun"), 4)
        ))

        // when
        cars.sortByDistanceDesc()

        // then
        assertEquals(cars.cars[0].name.value, "woni")
        assertEquals(cars.cars[1].name.value, "jun")
        assertEquals(cars.cars[2].name.value, "pobi")
    }
}