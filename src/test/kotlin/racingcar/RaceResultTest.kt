package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceResultTest {
    @Test
    fun `라운드별 진행 상황을 추가한다`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        cars[0].move(5)
        val result = RaceResult()

        result.addRoundProgress(cars)
        val output = result.progress()

        assertThat(output).contains("pobi : -")
        assertThat(output).contains("woni : ")
    }

    @Test
    fun `최대 위치값을 가진 자동차들이 우승자이다`() {
        val cars = listOf(Car("pobi"), Car("woni"), Car("jun"))
        cars[0].move(5)
        cars[2].move(5)
        val result = RaceResult()

        result.setWinners(cars)

        assertThat(result.winners).containsExactlyInAnyOrder("pobi", "jun")
    }
}