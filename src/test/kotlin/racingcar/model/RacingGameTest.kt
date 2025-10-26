package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    @DisplayName("모든 자동차가 랜덤 값 4 이상이면 전진한다.")
    fun `모든 자동차가 이동하는 경우`() {
        val cars = listOf(Car("pobi", 0), Car("crong", 0))
        val numberGenerator = NumberGenerator { 9 }
        val racingGame = RacingGame(numberGenerator)

        val movedCars = racingGame.raceOneRound(cars)

        movedCars.zip(cars).forEach { (movedCar, originalCar) ->
            assertThat(movedCar.position).isEqualTo(originalCar.position + 1)
            assertThat(movedCar).isNotSameAs(originalCar)
        }
    }

    @Test
    @DisplayName("모든 자동차가 랜덤 값 4 미만이면 정지한다.")
    fun `모든 자동차가 멈추는 경우`() {
        val cars = listOf(Car("pobi", 1), Car("crong", 2))
        val numberGenerator = NumberGenerator { 3 }
        val racingGame = RacingGame(numberGenerator)

        val movedCars = racingGame.raceOneRound(cars)

        movedCars.zip(cars).forEach { (movedCar, originalCar) ->
            assertThat(movedCar.position).isEqualTo(originalCar.position)
            assertThat(movedCar).isSameAs(originalCar)
        }
    }

    @Test
    @DisplayName("일부 자동차만 이동한 경우 정확히 반영된다.")
    fun `일부 자동차만 이동하는 경우`() {
        // given
        val numbers = listOf(3, 4, 9)
        var index = 0
        val numberGenerator = NumberGenerator { numbers[index++] }

        val cars = listOf(Car("pobi", 0), Car("crong", 0), Car("hynw", 0))
        val racingGame = RacingGame(numberGenerator)

        val movedCars = racingGame.raceOneRound(cars)

        assertThat(movedCars[0].position).isEqualTo(0)
        assertThat(movedCars[1].position).isEqualTo(1)
        assertThat(movedCars[2].position).isEqualTo(1)
    }

    @Test
    @DisplayName("가장 멀리 간 자동차 1명을 반환한다.")
    fun `단독 우승자 찾기`() {
        val cars = listOf(
            Car("pobi", 3),
            Car("crong", 5),
            Car("hynw", 2)
        )
        val racingGame = RacingGame(NumberGenerator { 0 })

        val winners = racingGame.findWinners(cars)

        assertThat(winners).extracting("name").containsExactly("crong")
    }

    @Test
    @DisplayName("동점인 자동차들이 모두 우승자로 반환된다.")
    fun `공동 우승자 찾기`() {
        val cars = listOf(
            Car("pobi", 4),
            Car("crong", 2),
            Car("hynw", 4)
        )
        val racingGame = RacingGame(NumberGenerator { 0 })

        val winners = racingGame.findWinners(cars)

        assertThat(winners).extracting("name")
            .containsExactlyInAnyOrder("pobi", "hynw")
    }

    @Test
    @DisplayName("자동차 리스트가 비어있는 경우, 우승자 리스트도 비어있다.")
    fun `빈 자동차 리스트의 경우`() {
        val cars = emptyList<Car>()
        val racingGame = RacingGame(NumberGenerator { 0 })

        val winners = racingGame.findWinners(cars)

        assertThat(winners).isEmpty()
    }
}