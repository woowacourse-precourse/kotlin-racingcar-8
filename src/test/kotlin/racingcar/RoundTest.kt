package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RoundTest {
    @Test
    fun `요구 조건을 만족하는 자동차들을 한칸 이동시킨다`() {
        assertSimpleTest {
            val cars = Round.startWith(listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"))
            val expectedCars = Round(
                listOf(
                    Car("0", 0), Car("1", 0), Car("2", 0), Car("3", 0),
                    Car("4", 0).moveForward(), Car("5", 0).moveForward(), Car("6", 0).moveForward(),
                    Car("7", 0).moveForward(), Car("8", 0).moveForward(), Car("9", 0).moveForward(),
                )
            )
            assertThat(cars.tryMoveForward((0..9).toList())).isEqualTo(expectedCars)
        }
    }

    @ParameterizedTest
    @CsvSource("0,1", "1,2", "2,3")
    fun `시도 횟수 만큼 전진 시키거나 멈춘다`(userInput: Int, roundSize: Int) {
        assertSimpleTest {
            val cars = Round(listOf(Car.withStartPosition("pobi"), Car.withStartPosition("jun")))
            val racingGame = Racing.start(cars, attempt = Attempt(userInput))
            assertThat(racingGame.totalRounds()).isEqualTo(roundSize)
        }
    }

    @Test
    fun `특정 라운드의 우승자를 결정한다`() {
        assertSimpleTest {
            val finalRound = Round(listOf(Car("pobi", 1), Car("jun", 2), Car("woni", 3)))
            assertThat(finalRound.getWinners()).isEqualTo(listOf(Car("woni", 3)))
        }
    }

    @Test
    fun `여러명의 우승자가 있는 경우 공동 우승으로 결정한다`() {
        assertSimpleTest {
            val finalRound = Round(listOf(Car("pobi", 3), Car("jun", 2), Car("woni", 3)))
            assertThat(finalRound.getWinners()).isEqualTo(listOf(Car("pobi", 3), Car("woni", 3)))
        }
    }
}