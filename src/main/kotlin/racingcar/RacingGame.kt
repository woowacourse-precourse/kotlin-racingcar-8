package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun playRound() {
        cars.forEach { car ->
            val randomValue = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM)
            car.move(randomValue)
        }
    }

    fun getCurrentStatus(): String {
        return cars.joinToString("\n") { car ->
            "${car.name} : ${car.getPositionDisplay()}"
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }
            .map { it.name }
    }

    companion object {
        private const val MIN_RANDOM = 0
        private const val MAX_RANDOM = 9
    }
}