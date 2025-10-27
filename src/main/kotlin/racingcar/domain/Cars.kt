package racingcar.domain

class Cars(private val cars: List<Car>) {

    fun moveAll(moveStrategy: (Car) -> Unit) {
        cars.forEach { moveStrategy(it) }
    }

    fun findWinners(): List<String> {
        val maxPosition = findMaxPosition()
        return cars.filter { it.getPosition() == maxPosition }
            .map { it.name }
    }

    fun getCarStatus(): List<Pair<String, Int>> {
        return cars.map { it.name to it.getPosition() }
    }

    private fun findMaxPosition(): Int {
        return cars.maxOf { it.getPosition() }
    }

    companion object {
        fun from(names: List<String>): Cars {
            val cars = names.map { Car(it) }
            return Cars(cars)
        }
    }
}