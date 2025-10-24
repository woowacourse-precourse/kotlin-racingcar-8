package racingcar.domain

import racingcar.port.OutputPort
import racingcar.util.RandomUtils

class Race(val cars: List<Car>) {
    fun runOneRound() {
        for (car in cars) {
            car.move(RandomUtils.getRandomInt())
        }
    }

    private fun findFinalMaxPosition(cars: List<Car>): Int {
        return cars.maxOf { it.position }
    }

    fun findWinners(): List<Car> {
        val maxPosition = findFinalMaxPosition(cars)
        val winners: MutableList<Car> = mutableListOf()

        for (car in cars) {
            if (car.position == maxPosition) {
                winners += car
            }
        }

        return winners
    }
}