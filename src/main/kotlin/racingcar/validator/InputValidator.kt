package racingcar.validator

object InputValidator {
    private const val MAX_NAME_LENGTH = 5

    fun validateCarNames(names: List<String>) {
        names.forEach { name ->
            validateCarName(name)
        }
    }

    private fun validateCarName(name: String) {
        require(name.isNotBlank()) { "자동차 이름은 빈 문자열이 될 수 없습니다." }
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 ${MAX_NAME_LENGTH}자 이하여야 합니다." }
    }

    fun validateRoundCount(count: String): Int {
        val roundCount = count.toIntOrNull()
            ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
        require(roundCount > 0) { "시도 횟수는 양수여야 합니다." }
        return roundCount
    }
}
