package racingcar

fun main() {
    val inputHandler = InputHandler()
    val outputHandler = OutputHandler()
    val car = Car()

    val carNames = inputHandler.getCarNames()
    car.addCar(carNames)
    val raceCount = inputHandler.getRaceCount()

    outputHandler.printRaceMessage()
    repeat(raceCount) {
        car.moveCar()
        outputHandler.printRaceResult(car.carsPosition)
    }

    val maxPosition = car.carsPosition.values.maxOrNull() ?: 0
    val winners = car.carsPosition.filter { it.value == maxPosition }.keys.toList()
    outputHandler.printWinners(winners)
}