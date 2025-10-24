package racingcar.model

class RacingGame(private val carNames: List<String>, private val tries: String) {
    private val cars = carNames.map { Car(it) }

    init {
        require(tries.toIntOrNull() != null) { "정수가 아닌 입력값입니다." }
        require(tries.toInt() != 0) { "횟수는 0보다 큰 정수이여야 합니다." }
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
