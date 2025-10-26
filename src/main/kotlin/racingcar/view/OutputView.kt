package racingcar.view

import racingcar.Messages
import racingcar.model.Car

object OutputView {

    fun showRacingStart() {
        println(Messages.RACING_RESULT)
    }

    fun showRoundResult(roundResult: List<Car>) {
        roundResult.map {
            println(
                "${it.getName()} : ${"-".repeat(it.getDistance())}"
            )
        }
        println()
    }

    fun showWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.getName() }

        println("${Messages.WINNER_PREFIX}$winnerNames")
    }
}