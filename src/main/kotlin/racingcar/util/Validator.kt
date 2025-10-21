package racingcar.util

import racingcar.util.Constants.ARRAY_SEPARATOR
import racingcar.util.Constants.EMPTY_ERROR_MESSAGE
import racingcar.util.Constants.FORMAT_ERROR_MESSAGE
import racingcar.util.Constants.LENGTH_ERROR_MESSAGE
import racingcar.util.Constants.MAX_LENGTH
import racingcar.util.Constants.MIN_LENGTH

object Validator {
    fun nameValidate(input: String): List<String> {
        nullValidate(input)
        val names = stringSeparator(input)
            .map { it.trim() }

        names.forEach { name ->
            nullValidate(name)
            lengthValidate(name)
        }
        return names
    }

    fun attemptalidator(input: String): Int {
        nullValidate(input)
        val attemptCount = input.toIntOrNull()
            ?: throw IllegalArgumentException(FORMAT_ERROR_MESSAGE)
        numberValidate(attemptCount)
        return attemptCount
    }

    private fun nullValidate(input: String) {
        require(input.isNotBlank()) { EMPTY_ERROR_MESSAGE }
    }

    private fun lengthValidate(input: String) {
        require(input.length in MIN_LENGTH..MAX_LENGTH) { LENGTH_ERROR_MESSAGE }
    }

    private fun stringSeparator(input: String): List<String> {
        return input.split(ARRAY_SEPARATOR)
    }

    private fun numberValidate(input: Int) {
        require(input >= MIN_LENGTH) { FORMAT_ERROR_MESSAGE }
    }
}