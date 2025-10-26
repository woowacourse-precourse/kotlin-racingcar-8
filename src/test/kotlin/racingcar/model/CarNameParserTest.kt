package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.application.main

class CarNameParserTest : NsTest() {

    @Test
    fun `자동차 이름 파싱 테스트`() {
        assertSimpleTest {
            val carList: List<Car> = Parser().parseCarName("pobi,woni")
            assertThat(carList).containsExactly(
                Car("pobi", 0), Car("woni", 0)
            )
        }
    } // 통과

    override fun runMain() {
        main()
    }

} // 통과