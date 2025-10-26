package racingcar.view

import racingcar.model.Car

class OutputView {

    companion object {
        private const val CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"
        private const val ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val EXECUTION_RESULT_MESSAGE = "\n실행 결과"
        private const val FINAL_WINNER_MESSAGE = "최종 우승자 : "
    }

    fun printCarNameInputMessage() {
        println(CAR_NAME_INPUT_MESSAGE)
    }

    fun printCountOfAttemptMessage() {
        println(ATTEMPT_COUNT_MESSAGE)
    }

    fun printExecutionResultMessage() {
        println(EXECUTION_RESULT_MESSAGE)
    }

    fun printOfRaceResult(cars: List<Car>) {
        val result = cars.joinToString("\n") { car ->
            val dash = "-".repeat(car.position)
            "${car.name} : $dash"
        }
        println("${result}\n")
    }

    fun printFinalWinner(winners: List<String>) {
        print("${FINAL_WINNER_MESSAGE}${winners.joinToString(", ")}")
    }
}