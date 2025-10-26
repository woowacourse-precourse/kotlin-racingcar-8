package racingcar.viewmodel

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.MoveStrategy
import racingcar.domain.RacingGameValidator

class RacingGameViewModelTest {

    private lateinit var viewModel: RacingGameViewModel

    @BeforeEach
    fun setUp() {
        viewModel = RacingGameViewModel(RacingGameValidator)
    }

    @Test
    @DisplayName("setupGame이 올바른 입력으로 정상적으로 게임을 초기화한다")
    fun `setupGame_WithValidInputs_InitializesGame`() {
        val carNames = "pobi,woni"
        val raceCount = "5"

        viewModel.setupGame(carNames, raceCount)

        assertThat(viewModel.getRaceCount()).isEqualTo(5)
        assertThat(viewModel.getWinnerNames()).containsExactlyInAnyOrder("pobi", "woni")
    }

    @Test
    @DisplayName("setupGame이 잘못된 차 이름 입력 시 예외를 전파한다")
    fun `setupGame_WithInvalidCarNames_ThrowsException`() {
        val invalidCarNames = "longlongname"
        val raceCount = "5"

        assertThatIllegalArgumentException()
            .isThrownBy { viewModel.setupGame(invalidCarNames, raceCount) }
    }

    @Test
    @DisplayName("playOneRound가 전략에 따라 상태를 변경하고 현재 차 목록을 반환한다")
    fun `playOneRound_UpdatesStateAndReturnsCurrentCars`() {
        viewModel.setupGame("pobi,woni", "2")
        val alwaysMoveStrategy = MoveStrategy { true }

        val carsAfterRound1 = viewModel.playOneRound(alwaysMoveStrategy)

        assertThat(carsAfterRound1).extracting("position").containsExactly(1, 1)

        val carsAfterRound2 = viewModel.playOneRound(alwaysMoveStrategy)

        assertThat(carsAfterRound2).extracting("position").containsExactly(2, 2)
    }

    @Test
    @DisplayName("getWinnerNames가 최종 우승자 이름 목록을 정확히 반환한다")
    fun `getWinnerNames_ReturnsCorrectWinners`() {
        viewModel.setupGame("pobi,woni,jun", "3")

        viewModel.playOneRound(MoveStrategy { true })
        val pobiWoniMoveStrategy = object : MoveStrategy {
            private var callCount = 0
            override fun canMove(): Boolean {
                return callCount++ < 2
            }
        }
        viewModel.playOneRound(pobiWoniMoveStrategy)
        viewModel.playOneRound(MoveStrategy { false })

        val winnerNames = viewModel.getWinnerNames()

        assertThat(winnerNames).containsExactlyInAnyOrder("pobi", "woni")
    }
}
