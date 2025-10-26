package car.view

import camp.nextstep.edu.missionutils.Console

val ERROR_MESSAGE_INVALID_ROUND_COUNT = "시도 횟수는 숫자여야 합니다."

class InputView {
    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return Console.readLine().split(",").map{it.trim()}
    }
    fun readRacingCount(): Int {
        println("시도할 횟수는 몇회인가요?")
        val input = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE_INVALID_ROUND_COUNT)
        return input
        }
}