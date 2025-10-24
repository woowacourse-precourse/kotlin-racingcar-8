package racingcar.model

object WinnerCalculator {

    fun calculateWinners(cars: List<Car>): List<String> {
        val maxWin = cars.maxOfOrNull { it.position }

        return cars.filter {
            it.position == maxWin
        }.map { it.name }
    }
}