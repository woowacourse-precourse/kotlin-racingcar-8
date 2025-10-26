package car.model

class RacingGame(private val moveStrategy: MoveStrategy){
    private val cars = mutableListOf<Car>()

    fun addCars(names: List<String>) {
        cars.forEach { it.position = 0 }
        cars.clear()
        names.forEach { name ->
            cars.add(Car(name))
        }
    }

    fun moveCars() {
        cars.forEach { car ->
            if (moveStrategy.shouldMove()) {
                car.move()
            }
        }
    }

    fun getCars(): List<Car> {
        return cars.toList()
    }
}