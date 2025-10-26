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
        val result = cars.joinToString("\n") { car ->
            val dash = "-".repeat(car.position)
            "${car.name} : $dash"
        }
        println(stringBuilder.toString())
    }

    fun printFinalWinner(winners: List<String>) {
        println("${RacingCarConstants.FINAL_WINNER_MESSAGE}${winners.joinToString(", ")}")
    }
}