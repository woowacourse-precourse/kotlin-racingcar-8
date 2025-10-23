package racingcar.domain

import racingcar.util.RandomUtils
import racingcar.view.ResultView

class Race(val cars: List<Car>, val tryCount: Int) {
    fun run() {
        for (i in 1..tryCount) {
            if (i == 1) {
                ResultView.printFirstResult()
            }

            for (car in cars) {
                car.move(RandomUtils.getRandomInt())
                ResultView.printRaceResult(car)
            }

            println()
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