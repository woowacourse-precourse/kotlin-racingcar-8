package racingcar

class InputValidator {
    fun validateCarNames(carNames: List<String>): List<String> {
        if (carNames.isEmpty() || carNames.any { it.isBlank() }) {
            throw IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.")
        }

        carNames.forEach { name ->
            if (name.length > 5) {
                throw IllegalArgumentException("자동차 이름 '$name'은 5자를 초과할 수 없습니다.")
            }
            if (name.isEmpty()) {
                throw IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.")
            }
        }

        val uniqueNames = carNames.toSet()
        if (uniqueNames.size != carNames.size) {
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
        }

        return carNames
    }

    fun validateRaceCount(input: String): Int {
        return try {
            val raceCount = input.toInt()
            if (raceCount <= 0) {
                throw IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.")
            }
            raceCount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("시도 횟수는 정수여야 합니다.")
        }
    }
}