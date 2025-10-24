package racingcar.io

import racingcar.domain.Car

object OutputView {
    /** 차량의 이름 [Car.name]과 위치 [Car.position]를 정해진 형태로 콘솔에 출력한다. */
    fun printCarStatus(car: Car) {
        val progressBar = "-".repeat(car.position)
        println("${car.name} : $progressBar")
    }

    /** 최종 우승자 [winners]를 정해진 형태로 콘솔에 출력한다. */
    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(separator = ", ")}")
    }
}