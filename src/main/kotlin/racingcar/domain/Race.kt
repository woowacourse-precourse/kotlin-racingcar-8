package racingcar.domain

import racingcar.util.RandomUtils.getRandomInt
import racingcar.view.ResultView.printFirstResult
import racingcar.view.ResultView.printRaceResult

class Race(val cars: List<Car>, val tryCount: Int) {
    fun run() {
        for(i in 1..tryCount) {
            if (i == 1){
                printFirstResult()
            }

            for (car in cars) {
                car.move(getRandomInt())
                printRaceResult(car)
            }

            println()
        }
    }

    fun findFinalMaxPosition(cars: List<Car>): Int{
        return cars.maxOf { it.position }
    }

    fun findWinners(maxPosition: Int): List<String> {
        val winners :MutableList<String> = mutableListOf()

        for (car in cars){
            if (car.position == maxPosition){
                winners += car.name
            }
        }

        return winners
    }
}