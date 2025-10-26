package racingcar.model

class Race(carName: List<String>, private val number: Number) {

    private val cars: List<Car> = carName.map { Car(it) }

    fun play() {
        cars.forEach { car ->
            val randomNumber = number.randomGenerator()
            car.move(randomNumber)
        }
    }

    fun getCars(): List<Car> = cars
}