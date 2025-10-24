package racingcar.constant

enum class ErrorType(val message: String) {
    EMPTY_INPUT("공백 입력은 허용되지 않습니다."),
    EMPTY_NAME("입력되지 않은 자동차 이름이 있습니다."),
    INVALID_NAME_LENGTH("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다."),
    INVALID_ROUND_TYPE("시도할 횟수는 정수만 입력할 수 있습니다."),
    INVALID_ROUND_RANGE("시도할 횟수는 1이상이어야 합니다.");
}