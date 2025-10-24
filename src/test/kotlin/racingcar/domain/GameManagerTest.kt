package racingcar.domain

import camp.nextstep.edu.missionutils.test.NsTest
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameManagerTest : NsTest() {
    @Test
    fun `findWinnerNames 단일 우승자`() {
        val cars = listOf(
            Car(NAME_A, 1), Car(NAME_B, 2), Car(NAME_C, 3)
        )

        val gameManager = GameManager(cars, 0)

        val result = gameManager.findWinnerNames()
        assertThat(result).containsOnly(NAME_C)
    }

    @Test
    fun `findWinnerNames 복수 우승자 출력`() {
        val cars = listOf(
            Car(NAME_A, 1), Car(NAME_B, 3), Car(NAME_C, 3)
        )

        val gameManager = GameManager(cars, 0)

        val result = gameManager.findWinnerNames()
        assertThat(result).contains(NAME_B, NAME_C)
    }

    @Test
    fun `findWinnerNames 특이 케이스 출력`() {
        val cars = listOf(
            Car(NAME_A), Car(NAME_B), Car(NAME_C)
        )

        val gameManager = GameManager(cars, 0)

        val result = gameManager.findWinnerNames()
        assertThat(result).contains(NAME_A, NAME_B, NAME_C)
    }

    @Test
    fun `findWinnerNames 빈 자동차 리스트`() {
        val cars = emptyList<Car>()
        val gameManager = GameManager(cars, 0)

        val result = gameManager.findWinnerNames()
        assertThat(result).isEmpty()
    }

    // GameManagerTest 클래스 내부에 추가
    private fun getPosition(cars: List<Car>, name: String): Int {
        return cars.first { it.name == name }.position
    }

    @Test
    fun `playRound 설정된 랜덤 값에 따라 자동차 위치를 정확히 업데이트해야 한다`() {
        // Given
        val carNames = listOf("pobi", "woni", "jun")

        assertRandomNumberInRangeTest({
            val cars = carNames.map { Car(it) }
            val gameManager = GameManager(cars = cars, maxRound = 1)

            val updatedCars: List<Car> = gameManager.playRound()

            // pobi(0), woni(1), jun(0)의 위치를 명확히 검증.
            assertThat(getPosition(updatedCars, "pobi")).isEqualTo(0)
            assertThat(getPosition(updatedCars, "woni")).isEqualTo(1)
            assertThat(getPosition(updatedCars, "jun")).isEqualTo(0)
        }, 1, 5, 3)
    }

    @Test
    fun `playRound 모든 Car가 전진하는 경우 위치가 정확히 1 증가해야 한다`() {
        // Given
        val carNames = listOf("pobi", "woni", "jun")

        assertRandomNumberInRangeTest({
            val cars = carNames.map { Car(it) }
            val gameManager = GameManager(cars = cars, maxRound = 1)

            val updatedCars: List<Car> = gameManager.playRound()

            // pobi(0), woni(1), jun(0)의 위치를 명확히 검증.
            assertThat(getPosition(updatedCars, "pobi")).isEqualTo(1)
            assertThat(getPosition(updatedCars, "woni")).isEqualTo(1)
            assertThat(getPosition(updatedCars, "jun")).isEqualTo(1)
        }, 5, 5, 5)
    }

    @Test
    fun `playRound 모든 Car가 멈추는 경우 위치가 변하지 않아야 한다`() {
        // Given
        val carNames = listOf("pobi", "woni", "jun")

        assertRandomNumberInRangeTest({
            val cars = carNames.map { Car(it) }
            val gameManager = GameManager(cars = cars, maxRound = 1)

            val updatedCars: List<Car> = gameManager.playRound()

            // pobi(0), woni(1), jun(0)의 위치를 명확히 검증.
            assertThat(getPosition(updatedCars, "pobi")).isEqualTo(0)
            assertThat(getPosition(updatedCars, "woni")).isEqualTo(0)
            assertThat(getPosition(updatedCars, "jun")).isEqualTo(0)
        }, -1, 2, 3)
    }

    override fun runMain() {}

    companion object {
        private const val NAME_A = "a"
        private const val NAME_B = "b"
        private const val NAME_C = "c"
    }
}