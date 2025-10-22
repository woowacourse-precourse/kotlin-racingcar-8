package racingcar.domain

/**
 * 사용자 입력 및 데이터 처리 과정에서 발생할 수 있는 오류 타입을 정의하는 열거형.
 *
 * 각 오류 타입은 콘솔이나 UI에 표시할 오류 메시지를 포함.
 *
 * @property message 해당 오류 발생 시 출력할 메시지 문자열
 */
enum class ErrorType(val message: String) {
    EMPTY_INPUT("빈 문자열은 입력할 수 없습니다."),
    INVALID_NUMBER("숫자가 아닙니다."),
    NOT_POSITIVE_NUMBER("0 이하의 횟수는 허용되지 않습니다."),
    EMPTY_NAME("공백인 이름은 허용되지 않습니다."),
    INVALID_NAME_LENGTH("이름은 5글자 이하만 허용됩니다."),
}