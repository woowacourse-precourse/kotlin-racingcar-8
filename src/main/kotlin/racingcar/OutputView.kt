package racingcar

object OutputView {

    fun printRoundStatus(cars: List<Car>) {
        cars.forEach { car ->
            val bar = "-".repeat(car.getPosition())
            println("${car.name} : $bar")
        }
    }

    fun printWinners(winnerNames: List<String>) {
        val text = winnerNames.joinToString(", ")
        println("최종 우승자 : $text")
    }
}
