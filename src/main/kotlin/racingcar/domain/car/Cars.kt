package racingcar.domain.car

class Cars(
    val cars: List<Car>
) {
    fun getWinners(): List<Car> {
        val max = cars.maxOf { it.distance }
        return cars.filter { it.distance == max }
    }
}