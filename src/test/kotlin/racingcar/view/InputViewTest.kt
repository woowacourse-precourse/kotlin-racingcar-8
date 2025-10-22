package racingcar.view

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class InputViewTest {
    @Test
    fun `입력 받은 자동차 이름이 문자열 형태로 반환되는지 확인한다`() {
        // given
        val fakeInput = "Hello World"
        val inputStream = ByteArrayInputStream(fakeInput.toByteArray())
        System.setIn(inputStream)

        // when
        val inputView = InputView()
        val result = inputView.getCarNameFromUser()

        // then
        assertTrue(result is String)
    }
}