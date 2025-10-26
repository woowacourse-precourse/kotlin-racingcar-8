package racingcar.validator

import racingcar.constant.ErrorType

object Validator {
    private const val MIN_NAME_LENGTH = 1
    private const val MAX_NAME_LENGTH = 5

    fun validateNotBlank(input: String) {
        require(input.isNotBlank()) { ErrorType.EMPTY_INPUT.message }
    }

    fun validateNameLengths(names: List<String>) {
        require(names.none { it.isBlank() }) { ErrorType.EMPTY_NAME.message }
        require(names.all { it.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH }) { ErrorType.INVALID_NAME_LENGTH.message }
    }

    fun validateRoundInput(input: String) {
        require(input.isNotBlank()) { ErrorType.EMPTY_INPUT.message }
        val parsedInput = input.toIntOrNull()
        require(parsedInput != null) { ErrorType.INVALID_ROUND_TYPE.message }
        require(parsedInput > 0) { ErrorType.INVALID_ROUND_RANGE.message }
    }
}