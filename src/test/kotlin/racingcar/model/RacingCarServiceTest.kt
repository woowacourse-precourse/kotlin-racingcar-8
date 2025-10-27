package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarServiceTest {
    val racingCarService = RacingCarService()

    @Test
    fun `자동차_이름_파싱_테스트`() {
        assertSimpleTest {
            val input = ""
            val res = listOf("d","d")
            assertThat(racingCarService.parseCarNameInput(input)).isEqualTo(res)
        }
    }
}