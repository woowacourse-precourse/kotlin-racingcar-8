package racingcar.view

import racingcar.model.Car
import racingcar.util.Constants.RESULT_MESSAGE

class OutputView {
    fun printHeader() {
        println()
        println(RESULT_MESSAGE)
    }

    fun printRoundResult(cars: List<Car>) {
        cars.forEach {car ->
            println("${car.name} : ${car.getPositionBar()}")
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString (", ")}")
    }
}