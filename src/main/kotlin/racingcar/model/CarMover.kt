package racingcar.model

class CarsMover(
    private val singleCarMover: SingleCarMover,
    private val rule: MovementRule
) {

    fun moveAll(cars: List<Car>) {
        cars.forEach { car ->
            val moveAndStop = rule.hasMoveAndStop()
            singleCarMover.move(car, moveAndStop)
        }
    }
}

class SingleCarMover() {

    fun move(car: Car, rule: Boolean) {
        if (rule) {
            car.position++
        }
    }
}