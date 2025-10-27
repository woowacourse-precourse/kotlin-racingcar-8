package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarAndRacingGameCreationTest {
    @Test
    fun `Car 및 Game 생성 기능 테스트`() {
        // given
        val testNames = listOf("pobi", "woni", "jun")
        val testRound = 5

        // when
        val carInstances = createCars(testNames)
        val racingGame = RacingGame(testRound, carInstances)

        // then
        assertThat(carInstances).extracting("name").containsOnly("pobi", "woni", "jun")
        assertThat(racingGame.round).isEqualTo(testRound)
        assertThat(racingGame.cars).isEqualTo(carInstances)
    }
}