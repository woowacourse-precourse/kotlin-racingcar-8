package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.MoveDecider

class RaceRoundTest {

    @Test
    fun `모든 자동차가 전진하는 라운드`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val alwaysMove = MoveDecider { true }
        val raceRound = RaceRound(alwaysMove)

        val moved = raceRound.runOnce(cars)

        assertThat(moved).containsExactly(true, true)
        assertThat(cars.map { it.position }).containsExactly(1, 1)
    }

    @Test
    fun `모든 자동차가 정지하는 라운드`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val neverMove = MoveDecider { false }
        val raceRound = RaceRound(neverMove)

        val moved = raceRound.runOnce(cars)

        assertThat(moved).containsExactly(false, false)
        assertThat(cars.map { it.position }).containsExactly(0, 0)
    }
}