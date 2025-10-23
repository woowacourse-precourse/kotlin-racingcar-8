package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Race
import racingcar.model.User

class RaceTest : NsTest() {

    @Test
    fun `랜덤값이 4 이상인 참가자만 전진`() {
        assertRandomNumberInRangeTest(
            {
                val users = listOf(User("a"), User("b"))
                val race = Race(users)

                race.play()
                assertThat(users[0].score).isEqualTo(1)
                assertThat(users[1].score).isEqualTo(0)
            }, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `라운드 실행 후 결과 반환`(){
        assertRandomNumberInRangeTest(
            {
                val users = listOf(User("a"), User("b"))
                val race = Race(users)

                race.play()

                val result = race.getScores()
                assertThat(result["a"]).isEqualTo(1)
                assertThat(result["b"]).isEqualTo(0)
            },
            MOVING_FORWARD, STOP
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}