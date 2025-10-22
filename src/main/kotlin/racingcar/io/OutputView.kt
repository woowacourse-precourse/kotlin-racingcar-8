package racingcar.io

import racingcar.domain.Car

object OutputView {
    /**
     * 차량의 이름과 위치를 정해진 형태로 출력한다.
     *
     * @param Car 출력할 차량의 이름
     */
    fun printCarStatus(car: Car) {
        val progressBar = "-".repeat(car.getPosition())
        println("${car.name} : $progressBar")
    }

    /**
     * 최종 우승자를 정해진 형태로 출력한다.
     *
     * @param winners 출력할 우승자 이름
     */
    fun printWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(separator = ", ")}")
    }
}