package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame(
    private val cars: List<Car>
) {

    fun runOneRound() {
        cars.forEach { car ->
            val randomValue = Randoms.pickNumberInRange(0, 9)
            car.tryMove(randomValue)
        }
    }

    fun getCarsSnapshot(): List<Car> {
        return cars
    }
}
