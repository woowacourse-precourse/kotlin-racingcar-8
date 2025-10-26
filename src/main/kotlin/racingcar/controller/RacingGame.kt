package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.view.ResultView

class RacingGame(
    private val names: List<String>,
    private val tryCount: Int
) {
    private val cars = Cars(names.map { Car(it) })

    fun start(): List<Car> {
        repeat(tryCount) {
            val randomNumbers = generateRandomNumbers()
            cars.moveAll(randomNumbers)
            ResultView.printRoundResult(cars.getStatus())
        }
        return cars.getWinners()
    }

    private fun generateRandomNumbers(): List<Int> {
        return List(names.size) { Randoms.pickNumberInRange(0, 9) }
    }
}
