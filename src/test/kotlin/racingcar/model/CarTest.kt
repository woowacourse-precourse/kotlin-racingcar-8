package racingcar.model

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.domain.Car

class CarTest : NsTest() {
    @Test
    fun `Car 객체 생성 테스트`() {
        val car = Car("pobi")

        assertThat(car.name).isEqualTo("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    override fun runMain() {
    }

}