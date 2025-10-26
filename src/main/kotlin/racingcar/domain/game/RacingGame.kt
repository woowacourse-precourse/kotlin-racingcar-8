package racingcar.domain.game

class RacingGame(carName: List<String>) {
    val cars: List<Car>

    init {
        val map = carName.map {
            it.trim()
        }.filter { it.isNotBlank() }.map { Car(it) }
        cars = map
    }

    fun playRound(): List<Car> {
        raceOnce()
        return cars
    }

    private fun raceOnce() {
        cars.forEach { car -> car.race(RandomNumberProvider(), DefaultMoveRule()) }
    }
}