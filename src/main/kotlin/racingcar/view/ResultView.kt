package racingcar.view

import racingcar.domain.Car

object ResultView {
    fun printRoundResult(statusList: List<String>) {
        statusList.forEach { println(it) }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val names = winners.joinToString(", ") { it.name }
        println("최종 우승자 : $names")
    }
}
