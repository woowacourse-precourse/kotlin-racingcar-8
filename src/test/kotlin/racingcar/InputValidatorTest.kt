package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    @Test
    fun `자동차의 이름이 없다면 IllegalArgumentException을 발생시킨다`() {
        // given
        val carName = mutableListOf<String>()

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator().validateCarName(carName) }
    }

    @Test
    fun `자동차의 이름이 5글자를 초과하면 IllegalArgumentException을 발생시킨다`() {
        // given
        val carName = listOf<String>("thisistest", "arguments")

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator().validateCarName(carName) }
    }

    @Test
    fun `자동차의 이름이 공백이라면 IllegalArgumentException을 발생시킨다`() {
        // given
        val carName = listOf<String>("pluto", " ")

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator().validateCarName(carName) }
    }

    @Test
    fun `이동 횟수가 정수가 아니면 IllegalArgumentException을 발생시킨다`() {
        // given
        val repeatTime = "String"

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator().validateTotalMovement(repeatTime) }
    }

    @Test
    fun `이동 횟수가 빈칸이라면 IllegalArgumentException을 발생시킨다`() {
        // given
        val repeatTime = ""

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator().validateTotalMovement(repeatTime) }
    }

    @Test
    fun `이동 횟수가 공백으로 주어지면 IllegalArgumentException을 발생시킨다`() {
        // given
        val repeatTime = " "

        // when & then
        assertThrows<IllegalArgumentException> { InputValidator().validateTotalMovement(repeatTime) }
    }
}