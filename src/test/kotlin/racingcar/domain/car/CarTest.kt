package racingcar.domain.car

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class CarTest {
    @Test
    fun Name_객체를_입력하면_자동차_객체가_생성된다() {
        // given
        val name = Name("pobi")

        // when
        val car = Car(name)

        // then
        assertEquals(car.name.value, "pobi")
        assertEquals(car.distance, 0)
    }

    @Test
    fun 경기_결과를_올바르게_가져온다() {
        // given
        val name = Name("pobi")
        val distance = 5

        // when
        val car = Car(name, distance)

        // then
        assertEquals(car.getResult(), "pobi : -----")
    }
}