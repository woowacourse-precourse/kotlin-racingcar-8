package racingcar.model

import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `전진 테스트`() {
        val car = Car("pobi")
        car.move(4)
        assert(car.getPosition() == 1)
    }

    @Test
    fun `정지 테스트`() {
        val car = Car("pobi")
        car.move(3)
        assert(car.getPosition() == 0)
    }

}