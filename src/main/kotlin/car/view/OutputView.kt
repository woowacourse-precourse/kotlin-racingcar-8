package car.view

import car.model.Car

class OutputView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${car.getPositionDisplay()}")
        }
        println()
    }
}

