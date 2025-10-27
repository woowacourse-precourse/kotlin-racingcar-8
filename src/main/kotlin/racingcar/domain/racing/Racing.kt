package racingcar.domain.racing

import racingcar.exception.ErrorMessage

class Racing private constructor(
    val attemptCount: AttemptCount,
    private val _roundResults: MutableList<String> = mutableListOf(),
) {
    val roundResults: String get() = _roundResults.joinToString("\n\n")

    fun canMove(n: Int): Boolean {
        return n >= MIN
    }

    fun saveRoundResults(roundResult: String) {
        _roundResults.add(roundResult)
    }

    companion object {
        private const val MIN: Int = 4

        fun from(input: String): Racing {
            return Racing(AttemptCount.from(input))
        }
    }
}

@JvmInline
value class AttemptCount private constructor(val value: Int) {

    companion object {
        fun from(input: String): AttemptCount {
            require(input.isNotBlank()) { ErrorMessage.ATTEMPT_COUNT_BLANK.message }
            val n = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.ATTEMPT_COUNT_NOT_INTEGER.message)
            return AttemptCount(n)
        }
    }
}