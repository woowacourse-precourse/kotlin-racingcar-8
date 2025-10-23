package racingcar

object OutputView {
    fun printRaceStartHeader() {
        println("\n실행 결과")
    }

    fun printCurrentRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            val distance = "-".repeat(car.position)
            println("${car.name} : $distance")
        }

        println()
    }

    fun printFinalWinners(winnerNames: List<String>) {
        val winnersText = winnerNames.joinToString(", ")

        println("최종 우승자 : $winnersText")
    }
}

