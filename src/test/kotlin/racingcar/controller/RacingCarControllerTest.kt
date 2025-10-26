package racingcar.controller

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.view.View

class TestView(
    val names: String,
    val count: String
): View() {
    var winners: List<String> = mutableListOf<String>()

    override fun inputName(): String = names
    override fun inputCount(): String = count
    override fun result(winnerList: List<String>) {
        winners = winnerList
    }
}

class RacingCarControllerTest {
    @Test
    fun `컨트롤러와 뷰가 잘 연결되었다` () {
        // given
        val names = "tori,pobi,woni"
        val count = "3"
        val testView = TestView(names, count)
        val inputController = InputController()
        val racingCarController = RacingCarController(testView, inputController)
        val output = mutableListOf<String>("tori")

        // when
        assertRandomNumberInRangeTest(
            {
                racingCarController.run()
            },
            4,4,3,4,4,3,4,3,3
        )

        // then
        assertThat(testView.winners).isEqualTo(output)
    }
}