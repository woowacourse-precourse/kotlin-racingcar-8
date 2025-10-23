package racingcar.model

class Cars {

    fun createCar(carNames: List<String>): List<Car> {
        val cars = mutableListOf<Car>()
        carNames.map { cars.add(Car(it))}
        return cars
    }
}