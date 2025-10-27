package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ApplicationTest : NsTest() {
    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "pobi,javaji", // 5자 초과
        "pobi,,woni",  // 이름이 비어있음
        "pobi, ,woni", // 이름이 공백
        ""             // 전체 입력이 비어있음
    ])
    fun `잘못된 자동차 이름 입력 시 예외 테스트`(inputNames: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(inputNames, "1") // 두 번째 입력 "1"은 도달하기 전에 예외 발생
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", " ", "", "0", "-1"])
    fun `잘못된 시도 횟수 입력 시 예외 테스트`(tryCount: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", tryCount) // 유효한 이름, 잘못된 횟수
            }
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}