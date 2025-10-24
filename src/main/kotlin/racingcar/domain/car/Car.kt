package racingcar.domain.car

import racingcar.exception.ErrorMessage

class Car private constructor(
    val name: Name,
    private var _distance: Int = 0,
) {
    val distance: Int get() = _distance

    fun move() {
        _distance++
    }

    companion object {
        fun from(input: String): Car {
            return Car(Name(input))
        }
    }
}

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