package racingcar

class InputValidator {
    fun validateCarName(carNames: List<String>) {
        require(carNames.isNotEmpty()) { "자동차의 이름을 입력하셔야 합니다" }
        for (carName in carNames) {
            require(carName.isNotBlank()) { "자동차의 이름은 빈칸일 수 없습니다" }
            require(carName.length <= MAX_CAR_NAME_LENGTH) { "자동차의 이름은 5글자 이하여야 합니다" }
        }
    }

    fun validateTotalMovement(totalMovement: String) {
        require(totalMovement.isNotEmpty()) { "이동 횟수를 입력하셔야 합니다" }
        require(totalMovement.isNotBlank()) { "빈칸으로 주어지면 안됩니다" }
        try {
            totalMovement.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("정수를 입력하셔야 합니다")
        }
    }

    companion object {
        const val MAX_CAR_NAME_LENGTH = 5
    }
}