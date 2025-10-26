package racingcar.model

class Race(names: List<String>) {
    val cars = names.map { Car(it) }

    fun playRound() {
        cars.forEach { it.move() }
    }

    fun findWinners(): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.name }
    }
}
