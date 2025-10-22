package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    fun doesNameExceedFive(){
        val input = "pobi,morethanfive"

        assertThatThrownBy {
            Validator.validateCarNames(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다")
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있으면 예외가 발생한다")
    fun doesNameBlank(){
        val input ="pobi, ,woni"

        assertThatThrownBy {
            Validator.validateCarNames(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 공백이거나 비어있을 수 없습니다")
    }

    @Test
    @DisplayName("자동차 이름이 중복되면 예외가 발생한다.")
    fun doesNameCouple(){
        val input = "pobi,woni,pobi"

        assertThatThrownBy {
            Validator.validateCarNames(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 중복될 수 없습니다")
    }

    @Test
    @DisplayName("시도할 횟수가 숫자가 아니면 예외가 발생한다")
    fun isCountNumber(){
        val input = "abc"

        assertThatThrownBy {
            Validator.validateTryCount(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("시도할 횟수는 숫자여야 합니다")
    }

    @Test
    @DisplayName("시도할 횟수가 1 미만이면 예외가 발생한다")
    fun doesNumberUnderOne(){
        val input = "0"

        assertThatThrownBy {
            Validator.validateTryCount(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("시도할 횟수는 1 이상의 양수여야 합니다.")
    }

    @Test
    @DisplayName("정상적인 이름과 횟수는 예외가 발생하지 않는다.")
    fun isInputNormal(){
        val validNames = "pobi,woni,jun"
        val validCount = "5"

        assertThatThrownBy {
            Validator.validateCarNames(validNames)
            Validator.validateTryCount(validCount)
        }
    }

}