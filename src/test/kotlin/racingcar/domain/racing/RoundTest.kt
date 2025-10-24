package racingcar.domain.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class RoundTest {

    @Test
    fun 한_라운드_실행_결과를_성공적으로_저장한다() {
        // given
        val pobiCar = Car.from("pobi")
        val woniCar = Car.from("woni")
        val round = Round()

        // when
        woniCar.move()

        round.saveRoundResult(pobiCar.name, pobiCar.distance)
        round.saveRoundResult(woniCar.name, woniCar.distance)

        // then
        assertEquals(round.roundResult, "pobi : \nwoni : -")
    }
}