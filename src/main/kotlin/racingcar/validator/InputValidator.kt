package racingcar.validator

object InputValidator {
    private const val MAX_NAME_LENGTH = 5
    private const val NAME_DELIMITER = ","

    fun validateCarNames(input: String): List<String> {
        require(input.isNotBlank()) { "자동차 이름은 빈 값일 수 없습니다." }

        val names = input.split(NAME_DELIMITER).map { it.trim() }

        names.forEach { validateNameLength(it) }
        validateDuplicateNames(names)

        return names
    }

    fun validateRounds(input: String): Int {
        val rounds = input.toIntOrNull()
            ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")

        require(rounds > 0) { "시도 횟수는 양수여야 합니다." }

        return rounds
    }

    private fun validateNameLength(name: String) {
        require(name.isNotBlank()) { "자동차 이름은 빈 값일 수 없습니다." }
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 ${MAX_NAME_LENGTH}자 이하여야 합니다." }
    }

    private fun validateDuplicateNames(names: List<String>) {
        require(names.size == names.toSet().size) { "자동차 이름은 중복될 수 없습니다." }
    }
}