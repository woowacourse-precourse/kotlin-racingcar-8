package racingcar.service.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.car.Name

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class RacingServiceTest {

    private val racingService = RacingService()

    @Test
    fun 시도할_횟수를_입력하면_경기_결과를_성공적으로_반환한다() {
        // given
        val input = "5"
        val cars = Cars(listOf(
            Car(Name("pobi")),
            Car(Name("woni")),
            Car(Name("jun"))
        ))

        // when
        val result = racingService.race(input, cars)

        // then
        assertEquals(result.rounds.size, 5)
        assertTrue(result.winners.isNotEmpty())
    }
}