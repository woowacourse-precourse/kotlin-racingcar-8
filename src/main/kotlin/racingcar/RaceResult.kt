package racingcar

class RaceResult {
    private val progress: StringBuilder = StringBuilder()
    var winners: List<String> = emptyList()
        private set

    fun addRoundProgress(cars: List<Car>) {
        cars.forEach { car ->
            addCarPosition(car)
        }
        progress.appendLine()
    }

    private fun addCarPosition(car: Car) {
        progress.append("${car.name} : ")
        repeat(car.position) { progress.append("-") }
        progress.appendLine()
    }

    fun progress(): String = progress.toString()

    fun setWinners(cars: List<Car>) {
        val maxPositon = cars.maxOfOrNull { it.position } ?: return
        winners = cars.filter { it.position == maxPositon }.map(Car::name)
    }
}