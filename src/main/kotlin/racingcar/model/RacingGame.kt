package racingcar.model

import racingcar.view.OutputView

class RacingGame(
    private val cars: List<Car>,
    private val count: Int
) {
    fun start(carsMover: CarsMover): List<Car> {
        repeat(count) {
            carsMover.moveAll(cars)
            OutputView().printOfRaceResult(cars)
        }
        return cars
    }
}