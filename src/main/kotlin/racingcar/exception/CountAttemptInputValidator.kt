package racingcar.exception

import racingcar.exception.CarNameInputValidator.Companion.INPUT_IS_EMPTY

class CountAttemptInputValidator {

    companion object {
        private const val COUNT_IS_NOT_NUMBER = "입력이 숫자가 아닙니다."
        private const val COUNT_IS_NOT_POSITIVE_NUMBER = "입력이 양수가 아닙니다."
        private const val COUNT_INPUT_ZERO = "0이 입력 되었습니다."
    }

    fun validateCountAttempt(input: String) {
        validateCountInputBlank(input)
        validateNumber(input)
        validatePositiveNumber(input)
        validateNotZero(input)
    }

    fun validateCountInputBlank(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException(INPUT_IS_EMPTY)
        }
    }

    private fun validateNumber(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(COUNT_IS_NOT_NUMBER)
        }
    }

    private fun validatePositiveNumber(input: String) {
        if (input.toInt() < 0) {
            throw IllegalArgumentException(COUNT_IS_NOT_POSITIVE_NUMBER)
        }
    }

    private fun validateNotZero(input: String) {
        if (input.toInt() == 0) {
            throw IllegalArgumentException(COUNT_INPUT_ZERO)
        }
    }
}

