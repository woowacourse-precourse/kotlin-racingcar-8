package racingcar.domain

import camp.nextstep.edu.missionutils.test.NsTest
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

    @Test
    fun `playAllRounds 정상 수행`() {
        val cars = listOf(
            Car(NAME_A), Car(NAME_B), Car(NAME_C)
        )
        val maxRound = 3
        val gameManager = GameManager(cars, maxRound)

        gameManager.playAllRounds { it.tryMove(true) }

        assertThat(gameManager.findWinnerNames().count()).isEqualTo(maxRound)
    }

    override fun runMain() {}

    companion object {
        private const val NAME_A = "a"
        private const val NAME_B = "b"
        private const val NAME_C = "c"
    }
}