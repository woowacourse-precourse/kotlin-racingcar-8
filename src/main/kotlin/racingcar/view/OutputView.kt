package racingcar.view

import racingcar.model.Car

object OutputView {

    fun showRacingStart() {
        println("\n실행 결과")
    }

    fun showRoundResult(roundResult: List<Car>) {
        roundResult.map { println(it.toString()) }
        println()
    }

    fun showWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.getName() }

        println("최종 우승자 : $winnerNames")
    }
}