package racingcar.model
import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.OutputView

private const val MIN_RANDOM_NUMBER = 0
private const val MAX_RANDOM_NUMBER = 9

class RacingGame {
    fun racing(carList: List<Car>, repeatNum: Int): List<Car> {
        var currentCars = carList
        repeat(repeatNum) {
            currentCars = raceOnce(currentCars)
            OutputView.printRaceProcess(currentCars)
        }
        val maxDistance = currentCars.maxByOrNull { it.position }?.position ?: Car.INITIAL_POSITION
        return currentCars.filter { it.position == maxDistance }
    }

    fun raceOnce(cars: List<Car>): List<Car> {
        return cars.map { it. move(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER))}
    }
}

