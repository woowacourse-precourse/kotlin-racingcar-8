package racingcar.service

import racingcar.domain.Car

object WinnerFinder {
    fun findWinners(cars: List<Car>): List<String> {
        if (cars.isEmpty()) return emptyList()
        val maxPos = cars.maxOf { it.position }
        return cars.filter { it.position == maxPos }.map { it.name }
    }
}
