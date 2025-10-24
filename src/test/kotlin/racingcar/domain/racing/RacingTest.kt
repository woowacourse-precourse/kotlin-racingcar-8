package racingcar.domain.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.Cars

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class RacingTest {

    @Test
    fun 자동차를_이동할_수_있는_경우_True를_반환한다() {
        // given
        val racing = Racing()

        // when
        val canMove = racing.canMove(4)

        // then
        assertTrue(canMove)
    }

    @Test
    fun 차수별_실행_결과를_성공적으로_저장한다() {
        // given
        val racing = Racing()

        val round1 = Round()
        val round2 = Round()

        val pobiCar = Car.from("pobi")
        val woniCar = Car.from("woni")

        // when
        woniCar.move()

        round1.saveRoundResult(pobiCar.name, pobiCar.distance)
        round1.saveRoundResult(woniCar.name, woniCar.distance)
        racing.saveRoundResults(round1)

        pobiCar.move()

        round2.saveRoundResult(pobiCar.name, pobiCar.distance)
        round2.saveRoundResult(woniCar.name, woniCar.distance)
        racing.saveRoundResults(round2)

        // then
        assertEquals(racing.roundResults, "pobi : \nwoni : -\n\npobi : -\nwoni : -")
    }

    @Test
    fun 우승자를_성공적으로_반환한다() {
        // given
        val racing = Racing()

        val round1 = Round()
        val round2 = Round()

        val pobiCar = Car.from("pobi")
        val woniCar = Car.from("woni")
        val cars = Cars.of(listOf(pobiCar, woniCar))

        // when
        woniCar.move()

        round1.saveRoundResult(pobiCar.name, pobiCar.distance)
        round1.saveRoundResult(woniCar.name, woniCar.distance)
        racing.saveRoundResults(round1)

        pobiCar.move()

        round2.saveRoundResult(pobiCar.name, pobiCar.distance)
        round2.saveRoundResult(woniCar.name, woniCar.distance)
        racing.saveRoundResults(round2)

        racing.saveWinners(cars.getWinners())
        // then
        assertEquals(racing.winners, "pobi, woni")
    }
}