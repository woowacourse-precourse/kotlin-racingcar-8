package racingcar.exception

class CarNameInputValidator {

    companion object {
        const val INPUT_IS_EMPTY = "입력값이 비어 있습니다."
        private const val NAME_LENGTH_MAX = "자동차 이름이 5자를 초과 했습니다."
        private const val NAME_DUPLICATION = "자동차 이름이 중복 입력 되었습니다."
        private const val NAME_IS_EMPTY = "자동차 이름이 비어 있습니다."
        private const val NAME_CONTAINS_BLANK = "자동차 이름 사이에 공백이 포함되어 있습니다."
        private const val LENGTH_MAX = 5
    }

    fun validateCarName(input: String) {
        val names = input.split(",")

        validateNameInputBlank(input)
        validateNameLengthMax5(names)
        validateNameDuplication(names)
        validateEmptyNames(names)
        validateContainsBlank(names)
    }

    fun validateNameInputBlank(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException(INPUT_IS_EMPTY)
        }
    }

    fun validateNameLengthMax5(names: List<String>) {
        names.forEach { names ->
            if (names.length > LENGTH_MAX) {
                throw IllegalArgumentException(NAME_LENGTH_MAX)
            }
        }
    }

    fun validateNameDuplication(names: List<String>) {
        val nameDuplication = names.toSet()

        if (names.size != nameDuplication.size) {
            throw IllegalArgumentException(NAME_DUPLICATION)
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