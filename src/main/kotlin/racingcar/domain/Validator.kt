package racingcar.domain

object Validator {
    const val NAME_LENGTH_LIMIT = 5

    /** 주어진 자동차 이름 [name]을 검증합니다. */
    fun validateCarName(name: String) : String {
        require(name.isNotBlank()) { ErrorType.EMPTY_NAME.message }
        require(name.length <= NAME_LENGTH_LIMIT) { ErrorType.INVALID_NAME_LENGTH.message }
        return name
    }

    /** 주어진 라운드 횟수 [number]가 올바른 지 확인합니다. */
    fun validateRound(number: Int): Int {
        require (number > 0) { ErrorType.NOT_POSITIVE_NUMBER.message }
        return number
    }
}


