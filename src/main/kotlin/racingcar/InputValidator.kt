package racingcar

class InputValidator {
    fun validateCarName(carNames: List<String>) {
        require(carNames.isNotEmpty()) { "자동차의 이름을 입력하셔야 합니다" }
        for (carName in carNames) {
            require(carName.isEmpty()) { "자동차의 이름을 입력하셔야 합니다" }
            require(carName.isNotBlank()) { "자동차의 이름은 빈칸일 수 없습니다" }
            require(carName.length > MAX_CAR_NAME_LENGTH) { "자동차의 이름은 5글자 이하여야 합니다" }
        }
    }

    companion object {
        const val MAX_CAR_NAME_LENGTH = 5
    }
}