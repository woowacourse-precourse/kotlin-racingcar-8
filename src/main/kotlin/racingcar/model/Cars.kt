package racingcar.model

class Cars {
    private val cars = mutableListOf<Car>()

    fun createCar(carNames: List<String>) {
        carNames.map { cars.add(Car(it)) }
    }

    fun startRound() {
        cars.map { it.move() }
    }

    fun getCars(): List<Car> = cars

}