package racingcar.domain.car

class Cars private constructor(
    val cars: List<Car>
) {
    fun sortedByDistanceDesc(): Cars =
        Cars(cars.sortedByDescending { it.distance })

    companion object {
        fun of(cars: List<Car>): Cars {
            return Cars(cars.toList())
        }
    }
}