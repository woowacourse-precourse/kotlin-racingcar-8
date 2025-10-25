package racingcar.model
import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.OutputView

private const val MIN_RANDOM_NUMBER = 0
private const val MAX_RANDOM_NUMBER = 9

class RacingGame(private val numberGenerator: NumberGenerator) {
    fun raceOneRound(cars: List<Car>): List<Car> {
        return cars.map { it. move(numberGenerator)}
    }

    fun findWinners(cars: List<Car>): List<Car> {
        val maxDistance = cars.maxByOrNull { it.position }?.position ?: Car.INITIAL_POSITION
        return cars.filter { it.position == maxDistance }
    }

}

