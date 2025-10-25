package racingcar.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {

    private val inputView = InputView()

    @Test
    fun `자동차 이름이 비어있으면 예외 발생`() {
        val names = listOf("", "pobi")
        assertThrows<IllegalArgumentException> {
            val method = InputView::class.java.getDeclaredMethod("validateCarNames", List::class.java)
            method.isAccessible = true
            try {
                method.invoke(inputView, names)
            } catch (e: java.lang.reflect.InvocationTargetException) {
                throw e.targetException // 내부 IllegalArgumentException을 다시 던짐
            }
        }
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 예외 발생`() {
        val names = listOf("abcdef", "pobi")
        assertThrows<IllegalArgumentException> {
            val method = InputView::class.java.getDeclaredMethod("validateCarNames", List::class.java)
            method.isAccessible = true
            try {
                method.invoke(inputView, names)
            } catch (e: java.lang.reflect.InvocationTargetException) {
                throw e.targetException
            }
        }
    }

}
