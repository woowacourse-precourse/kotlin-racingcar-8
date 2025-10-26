package racingcar.view

object OutputView {
    fun printStart() {
        println()
        println("실행 결과")
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}
