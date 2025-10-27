package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class RoundTest {
    @ParameterizedTest
    @MethodSource("movingConditionsAndExpectedCars")
    fun `요구 조건을 만족하는 자동차들을 한칸 이동시킨다`(startRound: Round, randomNumbers: List<Int>, nextRound: Round) {
        assertSimpleTest {
            assertThat(startRound.tryMoveForward(randomNumbers)).isEqualTo(nextRound)
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

    @ParameterizedTest
    @MethodSource("roundAndWinner")
    fun `특정 라운드의 우승자를 결정한다`(finalRound: Round, winners: List<Car>) {
        assertSimpleTest {
            assertThat(finalRound.getWinners()).isEqualTo(winners)
        }
    }

    companion object {
        @JvmStatic
        fun movingConditionsAndExpectedCars(): List<Arguments> {
            return listOf(
                Arguments.of(
                    Round(listOf(Car("pobi", 0), Car("jun", 0))),
                    listOf(0, 1),
                    Round(listOf(Car("pobi", 0), Car("jun", 0))),
                ),
                Arguments.of(
                    Round(listOf(Car("pobi", 0), Car("jun", 0))),
                    listOf(2, 3),
                    Round(listOf(Car("pobi", 0), Car("jun", 0))),
                ),
                Arguments.of(
                    Round(listOf(Car("pobi", 0), Car("jun", 0))),
                    listOf(4, 5),
                    Round(listOf(Car("pobi", 1), Car("jun", 1))),
                ),
                Arguments.of(
                    Round(listOf(Car("pobi", 0), Car("jun", 0))),
                    listOf(6, 7),
                    Round(listOf(Car("pobi", 1), Car("jun", 1))),
                ),
                Arguments.of(
                    Round(listOf(Car("pobi", 0), Car("jun", 0))),
                    listOf(8, 9),
                    Round(listOf(Car("pobi", 1), Car("jun", 1))),
                )
            )
        }

        @JvmStatic
        fun roundAndWinner(): List<Arguments> {
            return listOf(
                Arguments.of(
                    Round(listOf(Car("pobi", 1), Car("jun", 2), Car("woni", 3))),
                    listOf(Car("woni", 3))
                ),
                Arguments.of(
                    Round(listOf(Car("pobi", 3), Car("jun", 2), Car("woni", 3))),
                    listOf(Car("pobi", 3), Car("woni", 3))
                )
            )
        }
    }
}