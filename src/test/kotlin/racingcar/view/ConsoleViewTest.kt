package racingcar.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.main

class ConsoleViewTest: NsTest() {
    private lateinit var view: View

    @BeforeEach
    fun setUp() {
        view = ConsoleView()
    }

    @Test
    @DisplayName("자동차 이름과 시도할 횟수를 입력받기 전 프롬프트를 출력한다")
    fun readLinePromptTest() {
        assertSimpleTest {
            // When
            run("pobi,woni", "1")

            // Then
            assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
            assertThat(output()).contains("시도할 횟수는 몇 회인가요?")
        }
    }

    @Test
    @DisplayName("라운드 결과를 출력하기 전 헤더를 출력한다")
    fun roundResultHeaderTest() {
        assertSimpleTest {
            // When
            view.printRoundHeader()

            // Then
            assertThat(output()).contains("실행 결과")
        }
    }

    @Test
    @DisplayName("라운드 결과 출력 형식 테스트")
    fun roundResultTest() {
        assertSimpleTest {
            // Given
            val carStates = listOf("pobi" to 3, "woni" to 1, "jun" to 3)
            val expectedOutput = """
                pobi : ---
                woni : -
                jun : ---
            """.trimIndent()

            // When
            view.printRoundResult(carStates)

            // Then
            assertThat(output()).contains(expectedOutput)
        }
    }

    @Test
    @DisplayName("단독 우승자 출력 형식 테스트")
    fun singleWinnerTest() {
        assertSimpleTest {
            // When
            view.printWinners(listOf("pobi"))

            // Then
            assertThat(output()).contains("최종 우승자 : pobi")
        }
    }

    @Test
    @DisplayName("공동 우승자 출력 형식 테스트")
    fun multipleWinnerTest() {
        assertSimpleTest {
            // When
            view.printWinners(listOf("pobi", "jun"))

            // Then
            assertThat(output()).contains("최종 우승자 : pobi, jun")
        }
    }

    override fun runMain() {
        main()
    }
}
