package racingcar.view

import camp.nextstep.edu.missionutils.Console

class ConsoleView : View {
    override fun readCarNames(): String {
        printPrompt(PROMPT_CAR_NAMES)

        return Console.readLine()
    }

    override fun readRoundCounts(): String {
        printPrompt(PROMPT_ROUND_COUNT)

        return Console.readLine()
    }

    override fun printRoundHeader() = println(ROUND_HEADER)

    override fun printRoundResult(carStates: Map<String, Int>) = carStates.forEach { (name, position) ->
        println("$name : ${"-".repeat(position)}")
    }

    override fun printWinners(winners: List<String>) = println("$FINAL_WINNER${winners.joinToString(", ")}")

    private fun printPrompt(message: String) = println(message)

    companion object {
        private const val PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val PROMPT_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"
        private const val ROUND_HEADER = "\n실행 결과"
        private const val FINAL_WINNER = "최종 우승자 : "
    }
}
