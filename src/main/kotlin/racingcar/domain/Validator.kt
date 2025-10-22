package racingcar.domain

object Validator {
    const val NAME_LENGTH_LIMIT = 5

    /**
     * 주어진 자동차 이름을 검증합니다.
     *
     * @param name 자동차 이름
     * @throws IllegalArgumentException 자동차 이름이 빈 문자열이거나 5글자 미만인 경우 에러 발생
     */
    fun validateCarName(name: String) {
        if (name.isBlank()) throw  IllegalArgumentException(ErrorType.EMPTY_NAME.message)
        else if (name.length > NAME_LENGTH_LIMIT) throw IllegalArgumentException(ErrorType.INVALID_NAME_LENGTH.message)
    }

    /**
     * 주어진 라운드 횟수가 올바른 지 확인합니다.
     *
     * @param number 라운드 횟수
     * @throws IllegalArgumentException 자연수가 아닌 경우 에러 발생
     */
    fun validateRound(number: Int) {
        if (number <= 0) throw IllegalArgumentException(ErrorType.NOT_POSITIVE_NUMBER.message)
    }
}


