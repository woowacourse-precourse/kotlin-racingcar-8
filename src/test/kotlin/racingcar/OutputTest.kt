package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OutputTest: NsTest() {

    @Test
    fun `라운드별 실행 결과 출력`(){
        val result = mapOf(
            "pobi" to 1,
            "woni" to 0,
            "jun" to 2
        )
        assertSimpleTest {
            OutputView.displayRoundResult(result)
            assertThat(output()).contains("pobi : -", "woni : ", "jun : --")
        }

    }



    override fun runMain() {
        main()
    }
}