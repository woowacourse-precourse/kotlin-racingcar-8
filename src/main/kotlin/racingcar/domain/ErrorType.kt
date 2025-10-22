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
    NEGATIVE_NUMBER("음수는 허용되지 않습니다."),
    NAME_TOO_LONG("이름은 5자를 초과할 수 없습니다."),
    INVALID_DELIMITER("허용되지 않은 구분자입니다.")
}