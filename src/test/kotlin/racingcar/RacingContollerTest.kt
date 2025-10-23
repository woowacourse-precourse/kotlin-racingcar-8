package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class RacingControllerTest {
    @Test
    fun `자동차 이름에 공백을 넣을 시 IllegalArgumentException이 발생한다`() {
        // given
        val fakeInput = "sam, ,toby"
        val inputStream = ByteArrayInputStream(fakeInput.toByteArray())
        System.setIn(inputStream)

        // when
        assertThrows<IllegalArgumentException> { RacingController().run() }
    }
}