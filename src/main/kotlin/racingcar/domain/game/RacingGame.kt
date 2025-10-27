package racingcar.domain.game

import racingcar.adaptors.random.RandomNumberProvider
import racingcar.domain.error.ErrorCode.RACE_MUST_HAVE_PROGRESS
import racingcar.domain.rule.DefaultMoveRule

class RacingGame(carName: Collection<String>) {
    private val racingCars: Collection<Car>

    init {
        val map = carName.map {
            it.trim()
        }.filter { it.isNotBlank() }.map { RacingCar(it) }
        racingCars = map
    }

    fun playRound(): Collection<Car> {
        raceOnce()
        return racingCars
    }

    private fun raceOnce() {
        racingCars.forEach { car -> car.race(RandomNumberProvider(), DefaultMoveRule()) }
    }


    fun winnerResult(): List<String> {
        val max = racingCars.maxOf { it.position }
        require(max > 0) { RACE_MUST_HAVE_PROGRESS }
        return racingCars.stream().filter { it.position == max }.map(Car::name).toList()
    }
}