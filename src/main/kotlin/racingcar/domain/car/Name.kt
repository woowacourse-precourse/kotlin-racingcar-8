package racingcar.domain.car

import racingcar.exception.ErrorMessage

@JvmInline
value class Name(val value: String) {
    init {
        require(value.isNotBlank()) { ErrorMessage.CAR_NAME_BLANK.message }
        require(value.length <= MAX_LENGTH) { ErrorMessage.CAR_NAME_TOO_LONG.message }
    }

    companion object {
        private const val MAX_LENGTH: Int = 5
    }
}