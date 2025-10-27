package racingcar.view

import racingcar.model.Car

object OutputView {

    fun printStartRacing() {
        println("실행 결과")
    }

    fun printPerRound(cars: List<Car>) {
        val result = StringBuilder()
        cars.map {
            val location = "-".repeat(it.position)
            result.append("${it.name} : $location\n")
        }
        println(result.toString())
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(separator = ", ").trim()}")
    }
}