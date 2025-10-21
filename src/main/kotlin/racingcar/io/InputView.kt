package racingcar.io

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자 입력 안내 메시지 타입을 정의하는 열거형.
 *
 * 각 타입은 콘솔에 출력될 안내 메시지를 포함한다.
 *
 * @property message 출력될 안내 메시지 문자열
 */
enum class InputMessageType(val message: String) {
    CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ROUND("시도할 횟수는 몇 회인가요?");
}

/**
 * 입력 오류 메시지 타입을 정의하는 열거형.
 *
 * 각 타입은 콘솔에 출력될 안내 메시지를 포함한다.
 *
 * @property message 출력될 오류 메시지 문자열
 */
enum class InputError(val message: String) {
    EMPTY("빈 문자열은 입력할 수 없습니다."),
}

object InputView {
    /**
     * 매개변수로 주어진 안내 메시지를 출력하고, 사용자에게 콘솔로 입력 받은 문자열이 비어있는 지 검증 후 반환한다.
     *
     * @param type 사용자에게 출력 할 입력 안내 메시지의 타입
     * @return 빈 문자열이 아님이 검증된 문자열
     * @throws IllegalArgumentException 빈 문자열인 경우 오류 발생
     */
    fun readNoneEmptyLine(type: InputMessageType): String {
        println(type.message)

        val input = Console.readLine()

        if (input.trim().isEmpty()) throw IllegalArgumentException(InputError.EMPTY.message)
        return input
    }
}