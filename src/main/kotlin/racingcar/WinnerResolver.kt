package racingcar

object WinnerResolver {

    fun resolveWinners(cars: List<Car>): List<String> {
        val maxPosition = findMaxPosition(cars)
        return cars
            .filter { it.getPosition() == maxPosition }
            .map { it.name }
    }

    private fun findMaxPosition(cars: List<Car>): Int {
        if (cars.isEmpty()) {
            return 0
        }
        return cars.maxOf { it.getPosition() }
    }
}
