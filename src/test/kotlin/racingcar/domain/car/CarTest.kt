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
        val name = "pobi"

        // when
        val car = Car.from(name)

        // then
        assertEquals(car.name.value, "pobi")
        assertEquals(car.distance, 0)
    }

    @Test
    fun 자동차를_이동시키면_거리가_증가한다() {
        // given
        val car = Car.from("pobi")

        // when
        repeat(3) {
            car.move()
        }

        // then
        assertEquals(car.distance, 3)
    }
}