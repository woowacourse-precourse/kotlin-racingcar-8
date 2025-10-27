package racingcar

object OutputView {

    // 형식: "pobi : ---"
    fun printRoundStatus(cars: List<Car>) {
        cars.forEach { car ->
            val bar = "-".repeat(car.getPosition())
            println("${car.name} : $bar")
        }
    }

    // 형식: "최종 우승자 : pobi, jun"
    fun printWinners(winnerNames: List<String>) {
        val text = winnerNames.joinToString(", ")
        println("최종 우승자 : $text")
    }
}
