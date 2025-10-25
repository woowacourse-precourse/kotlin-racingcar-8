package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car

class InputControllerTest {
    @BeforeEach
    fun setUp() {
        nameList = listOf("tori", "pobi", "woni")
        carList = listOf(Car("tori"), Car("pobi"), Car("woni"))
        inputController = InputController()
    }

    @Test
    fun `쉼표로 이름을 분리하여 이름 리스트를 반환한다` () {
        // when
        val output = inputController.nameSplit(names)

        // then
        assertThat(output).isEqualTo(nameList)
    }

    @Test
    fun `자동차 리스트를 만든다` () {
        // when
        val output = inputController.createCarList(names)

        // then
        assertThat(output).isEqualTo(carList)
    }

    @Test
    fun `움직임 값을 정수로 반환한다` () {
        // when
        val output = inputController.countToInt(count)

        // then
        assertThat(output).isEqualTo(totalCount)
    }

    @Test
    fun `이름 값에서 예외를 반환한다` () {
        val invalidNameList = listOf("torrii","pobi!", "woni", "")

        assertThrows<IllegalArgumentException> {
            inputController.nameParser(invalidNameList)
        }
    }

    @Test
    fun `움직임 값에서 예외를 반환한다` () {
        val invalidCounts = listOf("a", "%", "ㅁ", "", "0")

        invalidCounts.forEach { input ->
            assertThrows<IllegalArgumentException> {
                inputController.countParser(input)
            }
        }
    }

    companion object {
        // given
        private const val names: String = "tori,pobi,woni"
        private const val count: String = "5"
        private const val totalCount: Int = 5
        private lateinit var nameList: List<String>
        private lateinit var carList: List<Car>
        private lateinit var inputController: InputController
    }
}