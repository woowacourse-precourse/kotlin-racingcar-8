package racingcar.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.CarManager
import racingcar.model.FixedNumberGenerator
import racingcar.model.InputParser

class RaceControllerTest {

    private lateinit var inputParser: InputParser
    private lateinit var carManager: CarManager

    @BeforeEach
    fun setUp() {
        inputParser = InputParser()
        carManager = CarManager(FixedNumberGenerator(5))
    }

    @Test
    fun startRace_onValidInput() {
        val carNames = "pobi,woni,jun"
        val time = "2"
        val parsedTime = time.toInt()

        val fakeInput = FakeInput(carNames, time)
        val fakeOutput = FakeOutput()

        val raceController = RaceController(
            carManager,
            inputParser,
            fakeInput,
            fakeOutput,
        )

        raceController.startRace()

        assertEquals(parsedTime, carManager.getCarLocation("pobi"))
        val expectedOutput = listOf(
            "[결과 출력]",
            "pobi : -",
            "woni : -",
            "jun : -",
            "pobi : --",
            "woni : --",
            "jun : --",
            "최종 우승자 : pobi, woni, jun"
        )

        assertEquals(expectedOutput, fakeOutput.getOutput())
    }

    @Test
    fun startRace_onInvalidInput() {
        val invalidCarNames = "longname,jun"
        val time = "2"

        val fakeInput = FakeInput(invalidCarNames, time)
        val fakeOutput = FakeOutput()

        val raceController = RaceController(
            carManager,
            inputParser,
            fakeInput,
            fakeOutput,
        )

        val exception = assertThrows<IllegalArgumentException> {
            raceController.startRace()
        }

        assertTrue(exception.message!!.contains("Invalid car input"))
        assertTrue(fakeOutput.getOutput().isEmpty())
    }
}