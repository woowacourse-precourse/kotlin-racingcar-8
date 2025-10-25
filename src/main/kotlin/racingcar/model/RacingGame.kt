package racingcar.model

import racingcar.Messages

class RacingGame(private val carNames: List<String>, private val tries: String) {
    private val cars = carNames.map { Car(it) }

    init {
        require(tries.toIntOrNull() != null) { Messages.NOT_INTEGER }
        require(tries.toInt() != 0) { Messages.NOT_SMALLER_THAN_ZERO }
        require(carNames.toSet().size == carNames.size  ) { Messages.DUPLICATE_NAME }
    }

    fun playRound(): List<Car> {
        cars.forEach { it.move() }
        return cars
    }

    fun getTries() = tries.toInt()

    fun getWinners(): List<Car> {
        val maxDistance = cars.maxOf { it.getDistance() }
        return cars.filter { it.getDistance() == maxDistance }
    }
}
