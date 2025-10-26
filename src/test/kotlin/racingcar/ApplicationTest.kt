package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
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
            assertThrows<IllegalArgumentException> { createUniqueCars(names) }
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
    fun `0~9사이 무작위 정수가 4이상인 자동차들을 한칸 이동시킨다`() {
        assertSimpleTest {
            val cars = createUniqueCars(listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"))
            val expectedCars = listOf(
                cars[0], cars[1], cars[2], cars[3],
                cars[4].moveForward(), cars[5].moveForward(), cars[6].moveForward(),
                cars[7].moveForward(), cars[8].moveForward(), cars[9].moveForward(),
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
