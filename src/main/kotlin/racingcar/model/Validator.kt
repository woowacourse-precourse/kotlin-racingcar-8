package racingcar.model
private const val ERROR_NO_CAR_NAMES = "최소 한 대 이상의 자동차 이름이 필요합니다."
private const val ERROR_BLANK_CAR_NAME = "자동차 이름은 빈 문자열일 수 없습니다."
private const val ERROR_CAR_NAME_TOO_LONG = "자동차 이름은 ${Car.MAX_CAR_NAME_LENGTH}글자를 초과할 수 없습니다."
private const val ERROR_EMPTY_TRIAL_COUNT = "시도 횟수는 빈 문자열일 수 없습니다."
private const val ERROR_TRIAL_COUNT_NOT_A_NUMBER = "시도 횟수는 숫자여야 합니다."
private const val ERROR_TRIAL_COUNT_NOT_POSITIVE = "시도 횟수는 1 이상의 정수여야 합니다."
private const val ERROR_DUPLICATE_CAR_NAME = "자동차 이름은 중복될 수 없습니다."


object Validator {
    fun validateCarNames(carNames: List<String>): Unit {
        require(carNames.isNotEmpty()) { ERROR_NO_CAR_NAMES }
        require(carNames.size == carNames.toSet().size) { ERROR_DUPLICATE_CAR_NAME }
        carNames.forEach {
            require(it.isNotBlank()) { ERROR_BLANK_CAR_NAME }
            require(it.length <= Car.MAX_CAR_NAME_LENGTH) { ERROR_CAR_NAME_TOO_LONG }
        }
    }
    fun validateRepeatNum(repeatNum: String) {
        require(repeatNum.isNotEmpty()) { ERROR_EMPTY_TRIAL_COUNT }
        val number = repeatNum.toIntOrNull()?: throw IllegalArgumentException( ERROR_TRIAL_COUNT_NOT_A_NUMBER )
        require(number > 0) { ERROR_TRIAL_COUNT_NOT_POSITIVE }
    }



}