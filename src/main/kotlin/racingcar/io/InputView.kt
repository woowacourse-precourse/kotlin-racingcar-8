package racingcar.io

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.ErrorType

/** 사용자 입력 안내 메시지 타입을 정의하는 열거형. */
enum class InputMessageType(val message: String) {
    CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"), ROUND("시도할 횟수는 몇 회인가요?");
}

object InputView {
    /** 매개변수로 주어진 안내 메시지를 출력하고, 사용자에게 콘솔로 입력 받은 문자열이 비어있는 지 검증 후 반환한다. */
    fun readNonEmptyLine(
        type: InputMessageType,
        reader: () -> String = { Console.readLine() },
    ): String {
        println(type.message)
        val input = reader()
        require(input.isNotBlank()) { ErrorType.EMPTY_INPUT.message }
        return input
    }
}