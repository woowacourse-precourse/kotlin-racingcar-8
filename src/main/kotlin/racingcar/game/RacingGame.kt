package racingcar.game

import racingcar.domain.Car
import racingcar.domain.Cars

class RacingGame(
    private val cars: Cars,
    private val moveDecider: MoveDecider
) {

    fun playGame(roundCount: Int) {
        repeat(roundCount) {
            playRound()
        }
    }

    fun playRound() {
        cars.moveAll { moveDecider.shouldMove() }
    }

    fun getRoundResult(): List<Car> {
        return cars.getCars()
    }

    fun getWinners(): List<String> {
        return cars.getWinnerNames()
    }

    companion object {
        fun withRandomDecider(cars: Cars): RacingGame {
            return RacingGame(cars, RandomMoveDecider())
        }
    }
}