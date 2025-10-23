package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.controller.main

class CarNameParserTest : NsTest() {

    @Test
    fun `자동차 이름 파싱 테스트`() {
        assertSimpleTest {
            val parser = Parser().parseCarName("pobi,woni")
            assertThat(parser).containsExactly("pobi", "woni")
        }
    }

    override fun runMain() {
        main()
    }

} // 통과