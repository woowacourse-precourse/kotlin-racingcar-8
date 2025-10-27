package racingcar.model.validator

object RoundCountValidator {
    fun validate(countInput: String): Int {
        val number = countInput.toIntOrNull()
            ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
        require(number > 0) { "시도 횟수는 1 이상이어야 합니다." }

        return number
    }
}