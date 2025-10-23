package racingcar.util

object InputValidator {
    fun validateCarNames(readCarNames: List<String>) {
        for (carName in readCarNames) {
            if (carName.length > 5) {
                throw IllegalArgumentException("${carName}이 5자를 초과합니다.")
            }
            if (carName.isBlank()) {
                throw IllegalArgumentException("입력받은 자동차 이름이 공백입니다.")
            }
        }
    }

    fun validateTryCount(readTryCount: Int?): Int{
        if (readTryCount == null || readTryCount == 0) {
            throw IllegalArgumentException("입력받은 수가 유효하지 않은 값입니다.")
        }
        return readTryCount
    }
}