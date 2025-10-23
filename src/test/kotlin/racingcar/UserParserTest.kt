package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.UserParser

class UserParserTest : NsTest() {

    @Test
    fun `이름 입력시 공백이면 에러`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(" ")
            }
        }
    }

    @ParameterizedTest(name = "입력: \"{0}\" -> IllegalArgumentException")
    @ValueSource(strings = ["pobi, ,jun", "pobi, jun,", ",pobi,jun"])
    fun `쉼표로 구분된 문자열이 공백이면 에러`(given: String) {
        assertThrows<IllegalArgumentException> {
            UserParser(given)
        }
    }

    @Test
    fun `쉼표로 구분된 문자열이 5자 초과면 에러`() {
        assertThrows<IllegalArgumentException> {
            UserParser("pobi,junjun")
        }
    }

    @Test
    fun `중복 이름이 없는 경우 태그 없이 User 리스트로 변환`() {
        val parser = UserParser("pobi,woni,jun")

        val users = parser.getUserList()
        assertThat(users).hasSize(3)
        assertThat(users.map { it.name }).containsExactly("pobi", "woni", "jun")
        assertThat(users.map { it.tag }).containsExactly(null, null, null)
        assertThat(users.map { it.score }).containsExactly(0, 0, 0)
    }

    @Test
    fun `중복 이름이 있으면 순서대로 태그 부여`() {
        val parser = UserParser("pobi,woni,pobi,pobi")
        val users = parser.getUserList()

        assertThat(users.map { it.name }).containsExactly("pobi", "woni", "pobi", "pobi")
        assertThat(users.map { it.tag }).containsExactly('A', null, 'B', 'C')
    }


    override fun runMain() {
        main()
    }
}