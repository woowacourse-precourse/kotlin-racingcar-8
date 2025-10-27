package racingcar

class OutputHandler {

    fun printRaceMessage() {
        println()
        println("실행 결과")
    }

    fun printRaceResult(carsPosition: Map<String, Int>) {
        for ((name, position) in carsPosition) {
            val progress = "-".repeat(position)
            println("$name : $progress")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        val winnerNames = winners.joinToString(", ")
        println("최종 우승자: $winnerNames")
    }
}