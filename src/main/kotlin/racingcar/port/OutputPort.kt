package racingcar.port

import racingcar.domain.Car

interface OutputPort {
    fun printFirstResult()
    fun printRoundResult(car: Car)
    fun printBlankLine()
    fun printFinalWinner(winners: List<Car>)
}