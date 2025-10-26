package racingcar.exception

import racingcar.RacingCarConstants.NAME_LENGTH_MAX
import racingcar.RacingCarConstants.NAME_DUPLICATION
import racingcar.RacingCarConstants.NAME_IS_EMPTY
import racingcar.RacingCarConstants.NAME_CONTAINS_BLANK

class CarNameInputValidator {
    fun validateCarName(input: String) {

        val names = input.split(",")
        CountAttemptInputValidator().validateBlank(input)
        validateNameLengthMax5(names)
        validateNameDuplication(names)
        validateEmptyNames(names)
        validateContainsBlank(names)
    }

    fun validateNameLengthMax5(names: List<String>) {

        names.forEach { names ->
            if (names.length > 5) {
                throw IllegalArgumentException(NAME_LENGTH_MAX)
            }
        }
    }

    fun validateNameDuplication(names: List<String>) {
        val nameDuplication = names.toSet()
        names.forEach { name ->
            if (names.size != nameDuplication.size) {
                throw IllegalArgumentException(NAME_DUPLICATION)
            }
        }
    }

    fun validateEmptyNames(names: List<String>) {
        if (names.any { it.isBlank() }) {
            throw IllegalArgumentException(NAME_IS_EMPTY)
        }
    }

    fun validateContainsBlank(names: List<String>) {
        if (names.any { it.contains(" ") }) {
            throw IllegalArgumentException(NAME_CONTAINS_BLANK)
        }
    }
}