package racingcar.service.car

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.car.Name
import racingcar.domain.car.NameParser

class CarService {
    fun createCars(input: String): Cars {
        val cars = NameParser.splitByComma(input)
            .map { Car(Name(it)) }
        return Cars(cars)
    }
}