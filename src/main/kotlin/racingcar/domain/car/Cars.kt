package racingcar.domain.car

class Cars(
    private val _cars: List<Car>
) {
    val cars: List<Car> get() = _cars.toList()

    fun getWinners(): List<Car> {
        val max = cars.maxOf { it.distance }
        return cars.filter { it.distance == max }
    }
}