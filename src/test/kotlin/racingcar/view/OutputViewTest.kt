package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val originalOut = System.out
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun `실행 결과 헤더를 출력한다`() {
        // when
        OutputView.printResultHeader()

        // then
        assertThat(outputStream.toString()).contains("실행 결과")
    }

    @Test
    fun `자동차 상태를 올바른 형식으로 출력한다`() {
        // given
        val cars = listOf(
            Car("pobi").apply { repeat(3) { moveForward() } },
            Car("woni").apply { repeat(1) { moveForward() } },
            Car("jun")  // 이동하지 않음
        )

        // when
        OutputView.printRoundResult(cars)

        // then
        val output = outputStream.toString().replace("\r\n", "\n") // Windows CRLF -> LF 변환
        assertThat(output).contains("pobi : ---")
        assertThat(output).contains("woni : -")
        assertThat(output).contains("jun : ")
        assertThat(output).endsWith("\n\n")  // 라운드 간 빈 줄 확인
    }

    @Test
    fun `단독 우승자를 올바른 형식으로 출력한다`() {
        // given
        val winners = listOf("pobi")

        // when
        OutputView.printWinners(winners)

        // then
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi")
    }

    @Test
    fun `공동 우승자를 올바른 형식으로 출력한다`() {
        // given
        val winners = listOf("pobi", "jun")

        // when
        OutputView.printWinners(winners)

        // then
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi, jun")
    }

    @Test
    fun `대시 문자열 생성 함수가 올바르게 동작한다`() {
        // when & then
        assertThat(OutputView.createDashes(0)).isEqualTo("")
        assertThat(OutputView.createDashes(1)).isEqualTo("-")
        assertThat(OutputView.createDashes(3)).isEqualTo("---")
        assertThat(OutputView.createDashes(5)).isEqualTo("-----")
    }
}