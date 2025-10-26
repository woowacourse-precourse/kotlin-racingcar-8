package car.viewmodel

import car.model.AlwaysMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingViewModelTest {
    @Test
    fun `자동차 이름이 5자를 초과하면 예외가 발생한다`() {
        val viewModel = RacingViewModel(AlwaysMoveStrategy())
        val exception = assertThrows<IllegalArgumentException> {
            viewModel.setupGame(listOf("pobi", "javaji"))
        }
        assertThat(exception.message).isEqualTo(ERROR_MESSAGE_CAR_NAME_LENGTH)
    }

    @Test
    fun `자동차 이름이 중복되면 예외가 발생한다`() {
        val viewModel = RacingViewModel(AlwaysMoveStrategy())
        val exception = assertThrows<IllegalArgumentException> {
            viewModel.setupGame(listOf("pobi", "pobi"))
        }
        assertThat(exception.message).isEqualTo(ERROR_MESSAGE_DUPLICATE_CAR_NAME)
    }

    @Test
    fun `시도 횟수가 0이면 예외가 발생한다`() {
        val viewModel = RacingViewModel(AlwaysMoveStrategy())
        val exception = assertThrows<IllegalArgumentException> {
            viewModel.coutninueGame(0)
        }
        assertThat(exception.message).isEqualTo(ERROR_MESSAGE_ZERO_COUNT)
    }

    @Test
    fun `시도 횟수가 음수면 예외가 발생한다`() {
        val viewModel = RacingViewModel(AlwaysMoveStrategy())
        val exception = assertThrows<IllegalArgumentException> {
            viewModel.coutninueGame(-1)
        }
        assertThat(exception.message).isEqualTo(ERROR_MESSAGE_ZERO_COUNT)
    }

    @Test
    fun `정상적인 자동차 이름으로 게임을 설정한다`() {
        val viewModel = RacingViewModel(AlwaysMoveStrategy())
        viewModel.setupGame(listOf("pobi", "crong", "honux"))
        assertThat(viewModel.getCurrentStatus()).hasSize(3)
    }
}

