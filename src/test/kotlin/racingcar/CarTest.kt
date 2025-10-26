package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `move increase position when randomNumber is 4 or higher`(){
        val car1 = Car("pobi")
        car1.move(4)
        assertThat(car1.position).isEqualTo(1)

        val car2 = Car("wobi")
        car2.move(5)
        assertThat(car2.position).isEqualTo(1)
    }

    @Test
    fun `move doesn't increase position when randomNumber is lower than 4`(){
        val car1 = Car("pobi")
        car1.move(3)
        assertThat(car1.position).isEqualTo(0)

        val car2 = Car("wobi")
        car2.move(0)
        assertThat(car2.position).isEqualTo(0)
    }
}