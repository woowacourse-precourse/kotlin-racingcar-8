package racingcar.application.converter

import racingcar.domain.error.ErrorCode.ATTEMPT_COUNT_MUST_BE_GREATER_THAN_ZERO
import racingcar.domain.error.ErrorCode.INVALID_ATTEMPT_COUNT_NUMBER

class StringToIntConverter : Converter<Int> {
    override fun convert(input: String): Int {
        try {
            val convertInt = input.toInt()
            if (convertInt <= 0) {
                throw IllegalArgumentException(ATTEMPT_COUNT_MUST_BE_GREATER_THAN_ZERO)
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_ATTEMPT_COUNT_NUMBER)
        }
        return input.toInt()
    }
}