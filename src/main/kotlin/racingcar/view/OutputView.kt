package racingcar.view

import racingcar.domain.Car
import racingcar.port.OutputPort

object OutputView : OutputPort {
    const val BAR = "-"

    override fun printFirstResult() {
        printBlankLine()
        println("실행 결과")
    }

    override fun printRoundResult(car: Car) {
        val positionBar = BAR.repeat(car.position)

        println("${car.name} : $positionBar")
    }

    override fun printBlankLine() {
        println()
    }

    override fun printFinalWinner(winners: List<Car>) {
        val winnersName = winners.joinToString(", ") { it.name }

        println("최종 우승자 : $winnersName")
    }
}
