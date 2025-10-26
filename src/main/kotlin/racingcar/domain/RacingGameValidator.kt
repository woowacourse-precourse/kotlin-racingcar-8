package racingcar.domain

object RacingGameValidator : GameValidator {
    private const val MAX_NAME_LENGTH = 5

    override fun validateCarNames(namesInput: String) {
        val names = namesInput.split(",")
        require(names.all { it.isNotBlank() && it.length <= MAX_NAME_LENGTH }) {
            "자동차 이름은 5자 이하이며, 쉼표(,)로 구분해야 합니다. (공백 이름 불가)"
        }
    }

    override fun validateRaceCount(countInput: String): Int {
        val count = countInput.toIntOrNull()
        require(count != null && count > 0) { "시도 횟수는 1 이상의 숫자여야 합니다." }
        return count
    }
}
