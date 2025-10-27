package racingcar

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    private val inputValidator = InputValidator()
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

        val names = Console.readLine()
        val carNames = names.split(",").map { it.trim() }

        return inputValidator.validateCarNames(carNames)
    }

    fun getRaceCount(): Int {
        println("시도할 횟수는 몇 회인가요?")

        val input = Console.readLine()

        return inputValidator.validateRaceCount(input)
    }
}