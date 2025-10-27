package racingcar.model

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.domain.CarName

class CarNameSplitTest : NsTest() {

    private lateinit var actualRsult: List<String>

    @Test
    fun `자동차 이름 분리`() {
        assertSimpleTest {
            run("pobi,woni,jun")
            assertThat(actualRsult).isEqualTo(listOf("pobi", "woni", "jun"))
        }
    }

    @Test
    fun `하나의 자동차 이름 분리`() {
        assertSimpleTest {
            run("pobi")
            assertThat(actualRsult).isEqualTo(listOf("pobi"))
        }
    }


    @Test
    fun `스페이스 포함 자동차 이름 분리`() {
        assertSimpleTest {
            run("pobi,wo ni")
            assertThat(actualRsult).isEqualTo(listOf("pobi", "wo ni"))
        }
    }


    @Test
    fun `중복 자동차 이름 분리`() {
        assertSimpleTest {
            run("pobi,pobi,pobi")
            assertThat(actualRsult).isEqualTo(listOf("pobi", "pobi", "pobi"))
        }
    }

    override fun runMain() {
        val input = Console.readLine()
        actualRsult = CarName.split(input)
    }
}