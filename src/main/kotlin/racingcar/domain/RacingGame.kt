package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.view.ConsoleView

class RacingGame(private val cars: List<Car>) {

    fun play(rounds: Int) {
        ConsoleView.showRaceHeader()
        repeat(rounds) {
            updateScores()
            ConsoleView.showRaceProgress(cars)
        }
    }

    private fun updateScores() {
        cars.forEach { updateScore(it) }
    }

    private fun updateScore(car: Car) {
        if (pickNumberInRange(0, 9) >= 4) car.score ++
    }

    fun winner(): List<Car> {
        val maxScore = cars.maxOf { it.score }
        return cars.filter { it.score == maxScore }
    }
}