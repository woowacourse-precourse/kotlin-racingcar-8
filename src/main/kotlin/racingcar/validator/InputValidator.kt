package racingcar.validator

object InputValidator {
    private const val MAX_CAR_NAME_LENGTH = 5
    private const val MIN_ROUND_COUNT = 1

    fun validateCarNames(carNames: List<String>) {
        validateCarNamesNotEmpty(carNames)
        carNames.forEach { carName ->
            validateSingleCarName(carName)
        }
    }

    private fun validateCarNamesNotEmpty(carNames: List<String>) {
        require(carNames.isNotEmpty()) {
            "최소 1대의 자동차가 필요합니다."
        }
    }

    private fun validateSingleCarName(carName: String) {
        validateCarNameNotBlank(carName)
        validateCarNameLength(carName)
    }

    private fun validateCarNameNotBlank(carName: String) {
        require(carName.isNotBlank()) {
            "자동차 이름은 빈 값일 수 없습니다."
        }
    }

    private fun validateCarNameLength(carName: String) {
        require(carName.length <= MAX_CAR_NAME_LENGTH) {
            "자동차 이름은 ${MAX_CAR_NAME_LENGTH}자 이하여야 합니다."
        }
    }

    fun validateRoundCount(roundCount: Int) {
        require(roundCount >= MIN_ROUND_COUNT) {
            "시도 횟수는 ${MIN_ROUND_COUNT} 이상이어야 합니다."
        }
    }
}