package racingcar.view

import racingcar.model.Car

object OutputView {
    fun printRound(cars: List<Car>) {
        cars.forEach { println(it.getStatus()) }
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}
