package racingcar.view

import racingcar.domain.Car

object OutputView {
    fun printStart() {
        println()
        println("실행 결과")
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
    fun printRound(cars: List<Car>){
        cars.forEach { car-> println("${car.name} : ${"-".repeat(car.position)}") }
        println()
    }
}
