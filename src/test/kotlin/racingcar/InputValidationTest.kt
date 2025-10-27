package racingcar.view

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream

class InputValidationTest {

    private lateinit var originalIn: InputStream

    @BeforeEach
    fun setUp() {
        originalIn = System.`in`
    }

    @AfterEach
    fun tearDown() {
        // Console가 내부 Scanner를 캐싱하므로 테스트 간 간섭 방지를 위해 닫아줌
        Console.close()
        System.setIn(originalIn)
    }

    // ---------- 이름 입력/파싱 ----------

    @Test
    fun `이름을 쉼표 기준으로 파싱하고 공백을 제거한다`() {
        // given
        feedInput("pobi, woni,  jun")

        // when
        val names = InputView.readNames()

        // then
        assertThat(names).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `빈 이름 조각이 있으면 예외를 던진다`() {
        // given
        feedInput("pobi,,jun")  // 중간 빈 조각

        // expect
        assertThatThrownBy { InputView.readNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `공백만 있는 이름은 예외를 던진다`() {
        // given
        feedInput("pobi,   ,jun")

        // expect
        assertThatThrownBy { InputView.readNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `이름이 5자를 초과하면 예외를 던진다`() {
        // given
        feedInput("abcdef,po")  // 6자

        // expect
        assertThatThrownBy { InputView.readNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    // ---------- 시도 횟수 ----------

    @Test
    fun `시도 횟수는 1 이상 정수여야 한다 - 정상 입력`() {
        // given
        feedInput("5")

        // when
        val count = InputView.readTrialCount()

        // then
        assertThat(count).isEqualTo(5)
    }

    @Test
    fun `시도 횟수가 0 이하면 예외를 던진다`() {
        // given
        feedInput("0")

        // expect
        assertThatThrownBy { InputView.readTrialCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `시도 횟수가 정수가 아니면 예외를 던진다`() {
        // given
        feedInput("abc")

        // expect
        assertThatThrownBy { InputView.readTrialCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    // ---------- 유틸 ----------

    private fun feedInput(vararg lines: String) {
        val joined = lines.joinToString(separator = System.lineSeparator()) + System.lineSeparator()
        System.setIn(ByteArrayInputStream(joined.toByteArray()))
    }
}
