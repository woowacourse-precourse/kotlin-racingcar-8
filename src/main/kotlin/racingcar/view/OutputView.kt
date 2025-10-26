package racingcar.view

import racingcar.RacingCarConstants
import racingcar.model.Car

class OutputView {
    fun printCarNameInputMessage() {
        println(RacingCarConstants.CAR_NAME_INPUT_MESSAGE)
    }

    fun printCountOfAttemptMessage() {
        println(RacingCarConstants.ATTEMPT_COUNT_MESSAGE)
    }

    fun printExecutionResultMessage() {
        println(RacingCarConstants.EXECUTION_RESULT_MESSAGE)
    }

    fun printOfRaceResult(cars: List<Car>) {
        val carsSize = cars.size - 1
        val stringBuilder = StringBuilder()

        for (i in 0..carsSize) {
            val dash = "-".repeat(cars[i].position)
            stringBuilder.append("${cars[i].name} : $dash")
            stringBuilder.append("\n")
        }
        println(stringBuilder.toString())
    }

    fun printFinalWinner(winners: List<String>) {
        println("${RacingCarConstants.FINAL_WINNER_MESSAGE}${winners.joinToString(", ")}")
    }
}