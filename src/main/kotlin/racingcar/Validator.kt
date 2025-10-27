package racingcar

object Validator {
    private const val MAX_NAME_LENGTH = 5
    private const val MIN_ATTEMPT_COUNT = 1

    fun validateCarNames(names: List<String>) {
        names.forEach { name ->
            validateCarNameNotEmpty(name)
            validateCarNameLength(name)
        }
    }

    private fun validateCarNameNotEmpty(name: String) {
        require(name.isNotEmpty()) { "자동차 이름은 비어있을 수 없습니다." }
    }

    private fun validateCarNameLength(name: String) {
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 ${MAX_NAME_LENGTH}자 이하여야 합니다." }
    }

    fun validateAttemptCount(count: Int) {
        require(count >= MIN_ATTEMPT_COUNT) { "시도 횟수는 ${MIN_ATTEMPT_COUNT} 이상이어야 합니다." }
    }
}
