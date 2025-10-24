package racingcar.service.car

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.util.Util

class CarService {
    fun createCars(input: String): Cars {
        val cars = mutableListOf<Car>()
        for (token in Util.splitByComma(input)) {
            cars.add(Car.from(token))
        }
        return Cars.of(cars)
    }
}