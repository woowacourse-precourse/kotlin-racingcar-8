package racingcar

data class OutputView(val attempt: Attempt) {
    val path = (0..attempt.value).map { TRACE_SYMBOL.repeat(it) }

    private fun showStatus(round: Round) {
        for (car in round) {
            println(car.name + " : " + path[car.position])
        }
    }

    fun showStatus(racing: Racing) {
        if (hasOnlyInitRound(racing)) return
        println("실행 결과")
        for (round in skipInitRound(racing)) {
            showStatus(round)
            println()
        }
    }

    private fun hasOnlyInitRound(racing: Racing) = racing.totalRounds() <= 1

    private fun skipInitRound(racing: Racing) = racing.drop(1)

    fun showWinner(racing: Racing) {
        val carNames = racing.getWinners().map { car ->
            car.name
        }
        println("최종 우승자 : ${carNames.joinToString(", ")}")
    }

    companion object {
        private const val TRACE_SYMBOL = "-"
    }
}