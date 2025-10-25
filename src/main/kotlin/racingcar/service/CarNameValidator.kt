package racingcar.service


import racingcar.domain.error.ErrorCode.NAMES_MUST_BE_COMMA_SEPARATED


class CarNameValidator : Validator {
    override fun validate(input: String): Unit {
        require(input.contains(",") && input.isNotBlank() && !input.trim().endsWith(',')) {
            NAMES_MUST_BE_COMMA_SEPARATED
        }
    }
}