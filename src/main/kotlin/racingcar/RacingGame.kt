package racingcar

class RacingGame(carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun race(attemptCount: Int): List<List<Car>> {
        val raceResults = mutableListOf<List<Car>>()
        repeat(attemptCount) {
            moveCars()
            raceResults.add(getRaceSnapshot())
        }
        return raceResults
    }

    private fun moveCars() {
        cars.forEach { it.move() }
    }

    private fun getRaceSnapshot(): List<Car> {
        return cars.toList()
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }
            .map { it.name }
    }
}
