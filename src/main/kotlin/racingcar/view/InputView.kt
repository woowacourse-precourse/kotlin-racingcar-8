package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validator.InputValidator

object InputView {
    private const val CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ROUND_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?"
    private const val DELIMITER = ","

    fun readCarNames(): List<String> {
        println(CAR_NAMES_PROMPT)
        val input = Console.readLine()
        val carNames = parseCarNames(input)
        InputValidator.validateCarNames(carNames)
        return carNames
    }

    fun readRoundCount(): Int {
        println(ROUND_COUNT_PROMPT)
        val input = Console.readLine()
        val roundCount = parseRoundCount(input)
        InputValidator.validateRoundCount(roundCount)
        return roundCount
    }

    fun parseCarNames(input: String): List<String> {
        return input.split(DELIMITER).map { carName ->
            carName.trim()
        }
    }

    fun parseRoundCount(input: String): Int {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
        }
    }
}