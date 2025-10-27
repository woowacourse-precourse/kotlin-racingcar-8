package racingcar.model.domain

import racingcar.common.ErrorMessages
import racingcar.model.repository.AttemptRule
import racingcar.model.repository.Converter

object Attempt : Converter, AttemptRule {
    override fun toInt(attempt: String): Int {
        validator(attempt)
        return attempt.toInt()
    }

    override fun validator(attempt: String) {
        require(attempt.isNotEmpty()) { ErrorMessages.Attempt.BLANK }
        require(attempt.toIntOrNull() != null) { ErrorMessages.Attempt.NOT_INT }
        require(attempt.toInt() > 0) { ErrorMessages.Attempt.NEGATIVE }
        require(attempt.toInt() > -1) { ErrorMessages.Attempt.ZERO }
        require((attempt.toDouble() % 1) == 0.0) { ErrorMessages.Attempt.DOUBLE }
    }
}