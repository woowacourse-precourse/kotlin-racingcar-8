package car.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `자동차를 추가하면 게임에 등록된다`() {
        val game = RacingGame(AlwaysMoveStrategy())
        game.addCars(listOf("pobi", "crong"))
        assertThat(game.getCars()).hasSize(2)
    }

    @Test
    fun `항상 전진하는 전략으로 자동차들이 이동한다`() {
        val game = RacingGame(AlwaysMoveStrategy())
        game.addCars(listOf("pobi", "crong"))
        game.moveCars()
        assertThat(game.getCars().all { it.position == 1 }).isTrue()
    }

    @Test
    fun `전진하지 않는 전략으로 자동차들이 정지한다`() {
        val game = RacingGame(NeverMoveStrategy())
        game.addCars(listOf("pobi", "crong"))
        game.moveCars()
        assertThat(game.getCars().all { it.position == 0 }).isTrue()
    }

    @Test
    fun `가장 멀리 이동한 자동차가 우승자다`() {
        val game = RacingGame(AlwaysMoveStrategy())
        game.addCars(listOf("pobi", "crong"))
        game.moveCars()
        val winners = game.getWinners()
        assertThat(winners).containsExactlyInAnyOrder("pobi", "crong")
    }
}
