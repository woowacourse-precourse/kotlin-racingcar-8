package racingcar.application.converter

import racingcar.domain.error.ErrorCode.INVALID_ATTEMPT_COUNT_NUMBER

class StringToIntConverter : Converter<Int> {
    override fun convert(input: String): Int {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_ATTEMPT_COUNT_NUMBER)
        }
        return input.toInt()
    }
}