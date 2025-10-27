package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarServiceTest {
    val racingCarService = RacingCarService()

    @Test
    fun `자동차_이름_파싱_테스트`() {
        assertSimpleTest {
            val input = "name1, name2, name3, name4"
            val res = listOf("name1", "name2", "name3", "name4")
            assertThat(racingCarService.parseCarNameInput(input)).isEqualTo(res)
        }
    }

    @Test
    fun `자동차_경주_참여자_생성_테스트`() {
        assertSimpleTest {
            val input = listOf("name1", "name2", "name3")
            val res = listOf(
                Car("name1"),
                Car("name2"),
                Car("name3")
            )
            assertThat(racingCarService.getRacingPlayers(input)).isEqualTo(res)
        }
    }

    @Test
    fun `자동차_경주_참여자_생성_예외_테스트_5글자이상`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { racingCarService.getRacingPlayers(listOf("name10")) }
        }
    }

    @Test
    fun `자동차_경주_참여자_생성_예외_테스트_미입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { racingCarService.getRacingPlayers(listOf("")) }
        }
    }

    @Test
    fun `자동차_경주_참여자_생성_예외_테스트_중복이름`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { racingCarService.getRacingPlayers(listOf("name1", "name1")) }
        }
    }

    @Test
    fun `자동차_경주_우승자_생성_테스트`() {
        assertSimpleTest {
            val input = listOf(
                Car("name1", 10),
                Car("name2", 15),
                Car("name3", 12)
            )
            val res = listOf("name2")
            assertThat(racingCarService.getWinPlayers(input)).isEqualTo(res)
        }
    }

    @Test
    fun `자동차_경주_다중_우승자_생성_테스트`() {
        assertSimpleTest {
            val input = listOf(
                Car("name1", 10),
                Car("name2", 15),
                Car("name3", 15)
            )
            val res = listOf("name2", "name3")
            assertThat(racingCarService.getWinPlayers(input)).isEqualTo(res)
        }
    }
}