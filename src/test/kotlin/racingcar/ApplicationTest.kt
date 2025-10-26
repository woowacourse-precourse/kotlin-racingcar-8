package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.params.provider.CsvSource

class ApplicationTest : NsTest() {

    @Test
    fun `자동차 이름은 한 글자 이상을 포함해야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car.withStartPosition("") }
        }
    }

    @Test
    fun `자동차 이름은 5글자 이하여야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car.withStartPosition("123456") }
        }
    }

    @Test
    fun `자동차 이름은 중복을 허용하지 않는다`() {
        assertSimpleTest {
            val names = listOf("A", "A")
            assertThrows<IllegalArgumentException> { Round.startWith(names) }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["\n", "\t", " ", "''", "\"", "\\", "``", "wo\ni!"])
    fun `자동차 이름은 다양한 특수문자를 허용한다`(specialName: String) {
        assertSimpleTest {
            assertDoesNotThrow { Car.withStartPosition(specialName) }
        }
    }

    @Test
    fun `요구 조건을 만족하는 자동차들을 한칸 이동시킨다`() {
        assertSimpleTest {
            val cars = Round.startWith(listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"))
            val expectedCars = Round(
                1, listOf(
                    Car("0", 0), Car("1", 0), Car("2", 0), Car("3", 0),
                    Car("4", 0).moveForward(), Car("5", 0).moveForward(), Car("6", 0).moveForward(),
                    Car("7", 0).moveForward(), Car("8", 0).moveForward(), Car("9", 0).moveForward(),
                )
            )
            assertThat(cars.tryMoveForward((0..9).toList())).isEqualTo(expectedCars)
        }
    }

    @Test
    fun `자동차 위치는 0미만일 수 없다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car("pobi", -1) }
        }
    }

    @ParameterizedTest
    @CsvSource("pobi, 0, ''", "jun, 1, -", "woni, 2, --")
    fun `자동차의 현재 상태 출력이 올바른 형식을 따르는 지 확인한다`(name: String, position: Int, output: String) {
        assertSimpleTest {
            val car = Car(name, position)
            assertThat(car.status()).isEqualTo("$name : $output")
        }
    }

    @Test
    fun `시도 횟수가 음수라면 예외로 처리한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { AttemptingNumber(-1) }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["123,", "1 ", " 2 ", " ", "abc"])
    fun `시도 횟수가 단일 숫자가 아니라면 예외로 처리한다`(userInput: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { AttemptingNumber(userInput.toInt()) }
        }
    }

    @Test
    fun `시도 횟수가 최대 데이터 범위를 넘어가는 경우`() {
        val maxValue = ((Int.MAX_VALUE).toLong() + 1).toString()
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { AttemptingNumber(maxValue.toInt()) }
        }
    }

    @ParameterizedTest
    @CsvSource("0,1", "1,2", "2,3")
    fun `시도 횟수 만큼 전진 시키거나 멈춘다`(userInput: Int, roundSize: Int) {
        assertSimpleTest {
            val cars = Round(0, listOf(Car.withStartPosition("pobi"), Car.withStartPosition("jun")))
            val racingGame = Racing.with(cars, attempt = AttemptingNumber(userInput))
            assertThat(racingGame.totalRounds()).isEqualTo(roundSize)
        }
    }

//    @Test
//    fun `기능 테스트`() {
//        assertRandomNumberInRangeTest(
//            {
//                run("pobi,woni", "1")
//                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
//            },
//            MOVING_FORWARD, STOP
//        )
//    }
//
//    @Test
//    fun `예외 테스트`() {
//        assertSimpleTest {
//            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
//        }
//    }
//
    override fun runMain() {
        main()
    }
//
//    companion object {
//        private const val MOVING_FORWARD: Int = 4
//        private const val STOP: Int = 3
//    }
}
