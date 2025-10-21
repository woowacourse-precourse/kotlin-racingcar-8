package racingcar.util

import racingcar.util.Constants.ARRAY_SEPARATOR
import racingcar.util.Constants.EMPTY_ERROR_MESSAGE
import racingcar.util.Constants.LENGTH_ERROR_MESSAGE
import racingcar.util.Constants.MAX_LENGTH
import racingcar.util.Constants.MIN_LENGTH

object Validator {
    fun nameValidate(input: String): List<String> {
        nullValidate(input)
        val names = stringSeparator(input)

        for (name in names) {
            nullValidate(name)
            lengthValidate(name)
        }
        return names
    }

    private fun nullValidate(input: String) {
        require(input.isNotEmpty() || input.isNotBlank()) { IllegalArgumentException(EMPTY_ERROR_MESSAGE) }
    }

    private fun lengthValidate(input: String) {
        require(input.length in MIN_LENGTH..MAX_LENGTH) {
            IllegalArgumentException(LENGTH_ERROR_MESSAGE)
        }
    }

    private fun stringSeparator(input: String): List<String> {
        return input.split(ARRAY_SEPARATOR)
    }
}