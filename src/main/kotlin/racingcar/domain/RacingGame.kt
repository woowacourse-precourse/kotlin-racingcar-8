package racingcar.domain

class RacingGame(carNames: List<String>) {
    val cars = carNames.map { Car(it) }

    fun moveCars() {
        cars.forEach { it.move() }
    }
}
