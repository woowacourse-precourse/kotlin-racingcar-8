package racingcar

private const val MAX_NAME_LENGTH = 5

object Validator {

    fun validateCarNames(carNamesInput: String?): List<String> {
        require(!carNamesInput.isNullOrBlank()) { "자동차 이름은 비어있을 수 없습니다" }
        val names = carNamesInput.split(",").map{it.trim()}

        names.forEach { name ->
            validateSingleCarName(name)
        }

        require(names.toSet().size == names.size) { "자동차 이름은 중복될 수 없습니다" }

        return names
    }

    private fun validateSingleCarName(name: String) {
        require(name.isNotBlank()) { "자동차 이름은 비어있을 수 없습니다" }
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 ${MAX_NAME_LENGTH}자 이하만 가능합니다" }
    }

    fun validateTryCount(tryCountInput: String?): Int {
        val tryCount = tryCountInput?.toIntOrNull()

        require(tryCount != null) { "시도할 횟수는 숫자여야 합니다" }
        require(tryCount > 0) { "시도할 횟수는 1 이상의 양수여야 합니다" }

        return tryCount
    }
}