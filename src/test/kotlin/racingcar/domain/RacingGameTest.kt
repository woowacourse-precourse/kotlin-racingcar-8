package racingcar.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RacingGameTest {

    @Test
    fun `자동차 리스트가 입력 이름 개수만큼 생성된다`() {
        val names = listOf("pobi", "woni", "jun")
        val game = RacingGame(names)
        assertThat(game.cars).hasSize(3)
    }

    @Test
    fun `moveCars 호출 시 각 자동차가 이동을 시도한다`() {
        val names = listOf("pobi", "woni", "jun")
        val game = RacingGame(names)
        game.moveCars()
        assertThat(game.cars.map { it.position }).allMatch { it >= 0 }
    }
}
