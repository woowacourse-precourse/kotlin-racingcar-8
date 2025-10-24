package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `findWinners()는 단독 우승자를 정확히 반환한다`() {
        val winnerCar = Car(name = "pobi")
        winnerCar.position = 5
        val loserCar = Car(name = "woni")
        loserCar.position = 3
        val race = Race(listOf(winnerCar, loserCar))

        val winners = race.findWinners()

        assertThat(winners).containsExactly(winnerCar)
    }

    @Test
    fun `findWinners()는 공동 우승자들을 모두 반환한다`() {
        val winnerCar1 = Car(name = "pobi")
        winnerCar1.position = 5
        val winnerCar2 = Car(name = "woni")
        winnerCar2.position = 5
        val race = Race(listOf(winnerCar1, winnerCar2))

        val winners = race.findWinners()

        assertThat(winners).containsExactly(winnerCar1, winnerCar2)
    }

    @Test
    fun `findWinners()는 모두 0점일 때 모든 참가자를 우승자로 반환한다`() {
        val winnerCar1 = Car(name = "pobi")
        val winnerCar2 = Car(name = "woni")
        val race = Race(listOf(winnerCar1, winnerCar2))

        val winners = race.findWinners()

        assertThat(winners).containsExactly(winnerCar1, winnerCar2)
    }
}