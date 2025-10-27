package racingcar.model

import racingcar.view.OutputView

class RacingGame(private val cars: List<Car>) {
    fun playRound() {
        cars.forEach { it.move() }
    }

    fun judgeResult(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }

        return winners
    }
}