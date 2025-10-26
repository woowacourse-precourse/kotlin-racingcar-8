package racingcar.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.main

class OutputTest : NsTest() {
    @Test
    fun `이름 입력 가이드 출력 테스트`() {
        assertSimpleTest {
            run()
            assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        }
    }

    @Test
    fun `시도 횟수 입력 가이드 출력 테스트`() {
        assertSimpleTest {
            run()
            assertThat(output()).contains("시도할 횟수는 몇 회인가요?")
        }
    }

    override fun runMain() {
        main()
    }
}