package racingcar.model

class RacingGame(private val carNames: List<String>) {
    private val cars = carNames.map { Car(it) }

    fun playRound(): List<Car> {
        cars.forEach { it.move() }
        return cars
    }

    fun getWinners(): List<Car> {
        val maxDistance = cars.maxOf { it.getDistance() }
        return cars.filter { it.getDistance() == maxDistance }
    }
}
