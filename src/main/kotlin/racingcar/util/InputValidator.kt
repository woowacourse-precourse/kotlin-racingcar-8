package racingcar.util

object InputValidator {
    private const val MAX_NAME_LENGTH = 5
    private const val MIN_TRY_COUNT = 1

    fun validateCarNames(carNames: List<String>) {
        require(carNames.size >= 2) { "자동차는 2대 이상이어야 합니다." }

        carNames.forEach { name ->
            require(name.isNotBlank()) { "자동차 이름은 공백일 수 없습니다." }
            require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 ${MAX_NAME_LENGTH}자 이하만 가능합니다." }
        }
    }

    fun validateRoundCount(rounds: String) {
        val count = rounds.toIntOrNull()
            ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")

        require(count >= MIN_TRY_COUNT) { "시도 횟수는 $MIN_TRY_COUNT 이상이어야 합니다." }
    }
}
