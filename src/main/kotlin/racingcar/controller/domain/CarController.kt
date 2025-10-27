package racingcar.controller.domain

import racingcar.model.domain.Car
import racingcar.model.domain.Randoms

class CarController(val names: List<String>, val attempt: Int) {
    private val cars: List<Car> = createCars()
    val _history: MutableList<List<Int>> = mutableListOf()

    val history: List<List<Int>>
        get() = _history.toList()

    fun createCars(): List<Car> {
        return names.map { Car(it) }
    }

    fun startRacing() {
        repeat(attempt) {
            advance()
            _history.add(cars.map { it.position })
        }
    }

    fun advance() {
        cars.forEach { car ->
            if (Randoms.isAdvance()) car.move()
        }
    }
}