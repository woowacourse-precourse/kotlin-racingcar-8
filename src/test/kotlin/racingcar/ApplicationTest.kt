package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
	@Test
	fun `기능 테스트`() {
		assertRandomNumberInRangeTest(
			{
				run("pobi,woni", "1")
				assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
			},
			MOVING_FORWARD, STOP
		)
	}

	@Test
	fun `예외 테스트`() {
		assertSimpleTest {
			assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
		}
	}

	@Test
	fun `우승자 출력 테스트`() {
		val car = Car("chan")
		val car2 = Car("cks")
		val car3 = Car("betts")

		repeat(5) { car.moveForward() }
		repeat(3) { car2.moveForward() }
		repeat(2) { car3.moveForward() }

		val cars = listOf(car, car2, car3)

		Racing.racingStart(cars, 0)

		assertThat(output()).isEqualTo("최종 우승자 : chan")
	}

	@Test
	fun `공동 우승자 출력 테스트`() {
		val car = Car("chan")
		val car2 = Car("cks")
		val car3 = Car("betts")

		repeat(5) { car.moveForward() }
		repeat(5) { car2.moveForward() }
		repeat(2) { car3.moveForward() }

		val cars = listOf(car, car2, car3)

		Racing.racingStart(cars, 0)

		assertThat(output()).isEqualTo("최종 우승자 : chan, cks")
	}

	@Test
	fun `이름 파싱 테스트`() {
		val input = "chan,hee,woo"

		val members = InputParser.parseNames(input)

		assertThat(members).containsExactly("chan", "hee", "woo")
	}

	@Test
	fun `시도 횟수 파싱 테스트`() {
		val input = "5"

		val members = InputParser.parseTryCount(input)

		assertThat(members).isEqualTo(5)
	}

	@Test
	fun `이름 5글자 초과 예외 테스트`() {
		assertThrows<IllegalArgumentException> {
			InputValidator.validateName(listOf("abcdef", "chan", "hi"))
		}
	}

	@Test
	fun `이름 0글자 예외 테스트`() {
		assertThrows<IllegalArgumentException> {
			InputValidator.validateName(listOf("chan", ""))
		}
	}

	@Test
	fun `시도 횟수 음수 예외 테스트`() {
		assertThrows<IllegalArgumentException> {
			InputValidator.validateTryCount(-1)
		}
	}

	override fun runMain() {
		main()
	}

	companion object {
		private const val MOVING_FORWARD: Int = 4
		private const val STOP: Int = 3
	}
}
