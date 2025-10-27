package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 이름 검증 및 초기 위치는 0이어야 한다`() {
        val car = Car("pobi")
        assertThat(car.name).isEqualTo("pobi")
        assertThat(car.position).isZero()
    }

    @Test
    fun `MoveDecider가 true일 때 전진한다`() {
        val alwaysMove = MoveDecider { true }
        val car = Car("pobi")

        val moved = car.moveIf(alwaysMove)

        assertThat(moved).isTrue()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `MoveDecider가 false일 때 멈춘다`() {
        val neverMove = MoveDecider { false }
        val car = Car("pobi")

        val moved = car.moveIf(neverMove)

        assertThat(moved).isFalse()
        assertThat(car.position).isEqualTo(0)
    }
}
