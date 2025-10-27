package racingcar.domain.game

class RacingGame(carName: Collection<String>) {
    private val cars: Collection<Car>

    init {
        val map = carName.map {
            it.trim()
        }.filter { it.isNotBlank() }.map { Car(it) }
        cars = map
    }

    fun playRound(): Collection<Car> {
        raceOnce()
        return cars
    }

    private fun raceOnce() {
        cars.forEach { car -> car.race(RandomNumberProvider(), DefaultMoveRule()) }
    }


    fun winnerResult(maxNumber: Int): List<String>? {
        for (i in maxNumber downTo 1) {
            val finalI = i
            val list: List<String> = cars.stream()
                .filter { car: Car? -> car!!.position == finalI }
                .map{ car: Car -> car.name }.toList()
            if (list.isNotEmpty()) {
                return list
            }
        }
        return null
    }
}