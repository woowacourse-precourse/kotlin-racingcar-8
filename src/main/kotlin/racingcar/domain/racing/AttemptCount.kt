package racingcar.domain.racing

import racingcar.exception.ErrorMessage

@JvmInline
value class AttemptCount private constructor(val value: Int) {

    companion object {
        fun from(input: String): AttemptCount {
            require(input.isNotBlank()) { ErrorMessage.ATTEMPT_COUNT_BLANK.message }
            val n = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.ATTEMPT_COUNT_NOT_POSITIVE.message)
            require(n > 0) { ErrorMessage.ATTEMPT_COUNT_NOT_POSITIVE.message }
            return AttemptCount(n)
        }
    }
}