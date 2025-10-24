package racingcar.domain.car

class Cars private constructor(
    val cars: List<Car>
) {
    fun getWinners(): List<String> {
        val top = cars.maxOf { it.distance }
        return cars.filter { it.distance  == top }
            .map { it.name.value }
    }

    companion object {
        fun of(cars: List<Car>): Cars {
            return Cars(cars.toList())
        }
    }
}