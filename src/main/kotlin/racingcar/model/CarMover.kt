package racingcar.model

class CarsMover(
    private val singleCarMover: SingleCarMover,
    private val rule: MovementRule
) {
    // 여러대의 차를 움직임
    fun moveAll(cars: List<Car>) {
        cars.forEach { car ->
            val moveAndStop = rule.hasMoveAndStop(RandomNumberGenerator().getRandomNumber())
            singleCarMover.move(car, moveAndStop)
        }
    }
}

class SingleCarMover() {
    // 1대의 차를 움직임
    fun move(car: Car, rule: Boolean) {
        if (rule) {
            car.position++
        }
    }
}