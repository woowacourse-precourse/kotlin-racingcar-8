package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.viewModel.CarRacingGameViewModel

class CarRacingGameViewModelTest {

    private val viewModel = CarRacingGameViewModel()

    @Test
    fun `시도 횟수가 1 미만이거나 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val testList: List<String> = listOf("0", "-1", "abc")
            testList.forEach { str ->
                viewModel.validateTryCount(str)
            }
        }
    }

    @Test
    fun `시도 횟수가 1 이상이면 정상적으로 반환된다`() {
        val tryCount = viewModel.validateTryCount("5")
        assertEquals(5, tryCount)
    }

    @Test
    fun `자동차 이름이 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            viewModel.validateCarName("aaaa,aaaa,bbbb")
        }
    }
}