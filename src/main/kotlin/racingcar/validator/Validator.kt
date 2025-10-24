package racingcar.validator

object Validator {
    private const val MIN_NAME_LENGTH = 1
    private const val MAX_NAME_LENGTH = 5

    fun validateNotBlank(input: String) {
        require(input.isNotBlank())
    }

    fun validateNameLengths(names: List<String>) {
        require(names.none { it.isBlank() })
        require(names.all { it.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH })
    }

    fun validateRoundInput(input: String) {
        require(input.isNotBlank())
        val parsedInput = input.toIntOrNull()
        require(parsedInput != null)
        require(parsedInput > 0)
    }
}