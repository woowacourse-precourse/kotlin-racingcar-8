package racingcar

object InputValidator {
    private const val MAX_NAME_LENGTH = 5

    fun validateCarNames(names: List<String>) {
        require(names.isNotEmpty()) { "자동차 이름은 최소 1개 이상 입력해야 합니다." }

        names.forEach { name ->
            validateCarName(name)
        }

        validateDuplicateNames(names)
    }

    private fun validateCarName(name: String) {
        require(name.isNotBlank()) { "자동차 이름은 공백일 수 없습니다." }
        require(name.length <= MAX_NAME_LENGTH) {
            "자동차 이름은 ${MAX_NAME_LENGTH}자 이하만 가능합니다."
        }
    }

    private fun validateDuplicateNames(names: List<String>) {
        require(names.size == names.toSet().size) {
            "자동차 이름은 중복될 수 없습니다."
        }
    }

    fun validateAttemptCount(count: Int) {
        require(count > 0) { "시도 횟수는 1 이상이어야 합니다." }
    }
}