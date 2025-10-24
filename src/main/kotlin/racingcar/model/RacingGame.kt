package racingcar.model

class RacingGame(
    private val cars: List<Car>,
    private val count: Int
) {
    fun start(carsMover: CarsMover): List<Car> {
        repeat(count) {
            carsMover.moveAll(cars)
        }
        return cars
    }
}