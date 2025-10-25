package racingcar.model
class RacingGame(private val numberGenerator: NumberGenerator) {
    fun raceOneRound(cars: List<Car>): List<Car> {
        return cars.map { it. move(numberGenerator)}
    }

    fun findWinners(cars: List<Car>): List<Car> {
        val maxDistance = cars.maxByOrNull { it.position }?.position ?: Car.INITIAL_POSITION
        return cars.filter { it.position == maxDistance }
    }

}

