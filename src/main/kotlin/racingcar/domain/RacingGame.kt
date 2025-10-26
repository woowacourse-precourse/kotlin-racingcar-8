package racingcar.domain

class RacingGame(val cars: List<Car>) {

    fun playRound(strategy: MoveStrategy): RacingGame {
        val nextCars = cars.map { car ->
            car.move(strategy)
        }
        return RacingGame(nextCars)
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        return cars.filter { it.position == maxPosition }
    }
}
