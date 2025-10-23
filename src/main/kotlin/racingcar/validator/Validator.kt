package racingcar.validator

object Validator {

    fun validateNotBlank(input: String) {
        require(input.isNotBlank())
    }

    fun validateNameLengths(names: List<String>) {
        require(names.none { it.isBlank() })
        require(names.all { it.length in 1..5 })
    }
}