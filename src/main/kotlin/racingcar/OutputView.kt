package racingcar

data class OutputView(val attempt: Attempt) {
    val path = (0..attempt.value).map { "-".repeat(it) }

    private fun showStatus(round: Round) {
        for (car in round) {
            println(car.name + " : " + path[car.position])
        }
    }

    fun showStatus(racing: Racing) {
        if (racing.totalRounds() <= 1) {
            return
        }
        println("실행 결과")
        for (round in racing.drop(1)) {
            showStatus(round)
            println()
        }
    }

    fun showWinner(racing: Racing) {
        val carNames = racing.getWinners().map { car ->
            car.name
        }
        println("최종 우승자 : ${carNames.joinToString(", ")}")
    }
}