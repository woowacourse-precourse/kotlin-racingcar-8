package racingcar.view

interface View {
    fun readCarNames(): String
    fun readRoundCounts(): String

    fun printRoundHeader()
    fun printRoundResult(carStates: List<Pair<String, Int>>)
    fun printWinners(winners: List<String>)
}
