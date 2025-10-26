package racingcar.application.validator

import racingcar.domain.error.ErrorCode

class CarNameValidator : Validator {
    override fun validate(input: String): Unit {
        require(input.contains(",") && input.isNotBlank() && !input.trim().endsWith(',')) {
            ErrorCode.NAMES_MUST_BE_COMMA_SEPARATED
        }
    }
}