package racingcar.exception

enum class ErrorMessage(val message: String) {
    CAR_NAME_BLANK("자동차 이름은 비어 있을 수 없습니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자리 이하여야 합니다."),
    ATTEMPT_COUNT_BLANK("시도할 횟수는 비어 있을 수 없습니다."),
    ATTEMPT_COUNT_NOT_INTEGER("정수가 아닙니다.")
}