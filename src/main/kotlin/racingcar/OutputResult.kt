package racingcar

object OutputResult {
    fun printCars(cars: List<Car>) {
        // forEach : 리스트의 각 요소를 순회
        cars.forEach { println(it.carStatus()) }
    }

    fun printWinners(winners: List<String>) {
        print("최종 우승자 : ${winners.joinToString(", ")}")
    }
}