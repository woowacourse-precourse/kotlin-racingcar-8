package racingcar.model

class RacingGame(private val carNames: List<String>, private val tries: String) {
    private val cars = carNames.map { Car(it) }

    fun playRound(): List<Car> {
        cars.forEach { it.move() }
        return cars
    }

    fun getTries() : Int{
        return tries.toInt()
    }
}
