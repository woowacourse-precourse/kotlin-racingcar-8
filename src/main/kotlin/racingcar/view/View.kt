package racingcar.view

interface View {
    fun readCarNames(): String
    fun readRoundCounts(): String

    fun printRoundHeader()
    fun printRoundResult(carStates: Map<String, Int>)
    fun printWinners(winners: List<String>)
}
