package racingcar.domain

class Cars(carNames: List<String>) {
    private val cars: List<Car> = carNames.map { name -> Car(name) }

    fun moveAll(moveDecider: () -> Boolean) {
        cars.forEach { car ->
            if (moveDecider()) {
                car.moveForward()
            }
        }
    }

    fun getWinnerNames(): List<String> {
        val maxPosition = findMaxPosition()
        return findCarsAtPosition(maxPosition)
    }

    private fun findMaxPosition(): Int {
        return cars.maxOf { car -> car.getPosition() }
    }

    private fun findCarsAtPosition(targetPosition: Int): List<String> {
        return cars.filter { car -> car.getPosition() == targetPosition }
            .map { car -> car.getName() }
    }

    fun getCars(): List<Car> {
        return cars
    }
}