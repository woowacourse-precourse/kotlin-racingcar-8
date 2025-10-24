package racingcar.service.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.Cars

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class RacingServiceTest {

    private val racingService = RacingService()

    @Test
    fun 시도할_횟수를_입력하면_경기_결과를_성공적으로_반환한다() {
        // given
        val input = "5"
        val cars = Cars.of(listOf(
            Car.from("pobi"),
            Car.from("woni"),
            Car.from("jun")
        ))

        // when
        val result = racingService.race(input, cars)

        // then
        assertThat(result.roundResults).contains("pobi : ", "woni : ", "jun : ")
    }
}