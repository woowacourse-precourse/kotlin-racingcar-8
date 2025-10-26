package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차 목록으로 Cars를 생성한다`() {
        // given
        val carNames = listOf("pobi", "woni", "jun")

        // when
        val cars = Cars(carNames)

        // then
        val carList = cars.getCars()
        assertThat(carList).hasSize(3)
        assertThat(carList[0].getName()).isEqualTo("pobi")
        assertThat(carList[1].getName()).isEqualTo("woni")
        assertThat(carList[2].getName()).isEqualTo("jun")
    }

    @Test
    fun `모든 자동차가 이동하면 각각의 위치가 업데이트된다`() {
        // given
        val cars = Cars(listOf("pobi", "woni"))
        val alwaysMove = { true }

        // when
        cars.moveAll(alwaysMove)

        // then
        val carList = cars.getCars()
        assertThat(carList).allMatch { car -> car.getPosition() == 1 }
    }

    @Test
    fun `이동 조건에 따라 일부 자동차만 이동한다`() {
        // given
        val cars = Cars(listOf("pobi", "woni", "jun"))
        var callCount = 0
        val selectiveMove = {
            callCount++
            callCount % 2 == 1  // 첫 번째, 세 번째만 이동
        }

        // when
        cars.moveAll(selectiveMove)

        // then
        val carList = cars.getCars()
        assertThat(carList[0].getPosition()).isEqualTo(1)  // pobi
        assertThat(carList[1].getPosition()).isEqualTo(0)  // woni
        assertThat(carList[2].getPosition()).isEqualTo(1)  // jun
    }

    @Test
    fun `우승자는 가장 멀리 간 자동차들이다`() {
        // given
        val cars = Cars(listOf("pobi", "woni", "jun"))
        val carList = cars.getCars()

        // pobi: 3칸, woni: 1칸, jun: 3칸 이동
        repeat(3) { carList[0].moveForward() }
        repeat(1) { carList[1].moveForward() }
        repeat(3) { carList[2].moveForward() }

        // when
        val winners = cars.getWinnerNames()

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun")
    }

    @Test
    fun `모든 자동차가 같은 위치에 있으면 모두 우승자다`() {
        // given
        val cars = Cars(listOf("pobi", "woni", "jun"))
        val carList = cars.getCars()

        // 모든 자동차 2칸 이동
        repeat(2) {
            carList.forEach { car -> car.moveForward() }
        }

        // when
        val winners = cars.getWinnerNames()

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun")
    }

    @Test
    fun `아무도 이동하지 않으면 모두 우승자다`() {
        // given
        val cars = Cars(listOf("pobi", "woni"))

        // when (아무도 이동하지 않음)
        val winners = cars.getWinnerNames()

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni")
    }
}