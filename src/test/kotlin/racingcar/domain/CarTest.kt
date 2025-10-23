package racingcar.domain

import racingcar.main
import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest : NsTest() {
    @Test
    fun `주입된 랜덤값에 따라 이동 여부 결정`() {
        val car = Car("pobi")
        car.tryMove(false)
        car.tryMove(true)
        car.tryMove(false)
        car.tryMove(true)

        val lastPosition = car.positionValue
        assertThat(lastPosition).isEqualTo(2)
    }

    @Test
    fun `RandomGenerator 결과값에 따라 이동 누적`() {
        val car = Car("pobi")
        assertRandomNumberInRangeTest(
            {
                car.tryMove()
                car.tryMove()
                car.tryMove()
                car.tryMove()
            },
            4, 5, 3,8
        )

        val lastPosition = car.positionValue
        assertThat(lastPosition).isEqualTo(3)
    }

    override fun runMain() {
        main()
    }
}