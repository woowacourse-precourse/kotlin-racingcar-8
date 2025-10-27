package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(carNames: List<String>) {
    private val cars: List<Car> = carNames.map { Car(it) }

    fun playRound(): List<Car> {
        cars.forEach { car ->
            val randomValue = generateRandomValue()
            car.move(randomValue)
        }
        return cars
    }

    fun findWinners(): List<String> {
        val maxPosition = findMaxPosition()
        return cars.filter { it.getPosition() == maxPosition }
            .map { it.name }
    }

    private fun generateRandomValue(): Int {
        return Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM)
    }

    private fun findMaxPosition(): Int {
        return cars.maxOf { it.getPosition() }
    }

    companion object {
        private const val MIN_RANDOM = 0
        private const val MAX_RANDOM = 9
    }
}
