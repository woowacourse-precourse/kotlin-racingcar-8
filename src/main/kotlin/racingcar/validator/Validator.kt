package racingcar.validator

import racingcar.constant.MAX_NAME_LENGTH
import racingcar.constant.MIN_NAME_LENGTH

object Validator {

    fun validateNotBlank(input: String) {
        require(input.isNotBlank())
    }

    fun validateNameLengths(names: List<String>) {
        require(names.none { it.isBlank() })
        require(names.all { it.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH })
    }
}