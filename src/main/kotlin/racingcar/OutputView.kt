package racingcar

object OutputView {
    fun printResultHeader() {
        println()
        println("실행 결과")
    }

    fun printRoundResult(status: String) {
        println(status)
        println()
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}