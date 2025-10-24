package racingcar.util

object Validator {

    fun validateRoundCheck(round: Int) {
        if (round < 0) {
            throw IllegalArgumentException("음수 라운드는 존재할 수 없습니다.")
        }
    }

    fun validateCarNames(carNames: List<String>) {
        carNames.forEach { name ->
            checkNotEmpty(name)
            checkNameLength(name)
        }
    }

    private fun checkNotEmpty(carName: String) {
        if (carName.isEmpty()) {
            throw IllegalArgumentException("자동차 이름이 비어 있습니다")
        }
    }

    private fun checkNameLength(carName: String) {
        if (carName.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }
}