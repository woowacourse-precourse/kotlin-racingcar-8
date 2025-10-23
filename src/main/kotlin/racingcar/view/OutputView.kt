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
}