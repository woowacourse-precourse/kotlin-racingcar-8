package racingcar.view

import racingcar.model.Car

object OutputView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            val positions = "-".repeat(car.position)
            println("${car.name} : $positions")
        }
    }

    fun printWinner(cars: List<Car>) {
        // 자동차들의 position 중에서 가장 높은 값을 찾고
        val max = cars.maxOf { it.position }
        val winners = cars.filter { it.position == max }.joinToString(",") { it.name }
        println("최종 우승자 : ${winners}")
    }
}