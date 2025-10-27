package racingcar.domain.game

import racingcar.domain.error.ErrorCode.RACE_MUST_HAVE_PROGRESS

class RacingGame(carName: Collection<String>) {
    private val cars: Collection<Car>

    init {
        val map = carName.map {
            it.trim()
        }.filter { it.isNotBlank() }.map { Car(it) }
        cars = map
    }

    fun playRound(): Collection<Car> {
        raceOnce()
        return cars
    }

    private fun raceOnce() {
        cars.forEach { car -> car.race(RandomNumberProvider(), DefaultMoveRule()) }
    }


    fun winnerResult(): List<String> {
        val max = cars.maxOf { it.position }
        require(max > 0) { RACE_MUST_HAVE_PROGRESS }
        return cars.stream().filter { it.position == max }.map{it.name}.toList()
    }
}