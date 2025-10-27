package racingcar.model

import racingcar.util.InputValidator.validateCarNames
import racingcar.util.InputValidator.validateRoundCount
import racingcar.util.NumberGenerator
import racingcar.util.RandomNumberGenerator

class RacingGame(
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    private var _cars: List<Car> = listOf()

    private var _rounds: Int = 0
    val rounds: Int
        get() = _rounds

    fun setup(carNamesInput: String, roundsInput: String) {
        val carNames = carNamesInput.split(",")

        validateCarNames(carNames)
        validateRoundCount(roundsInput)

        _cars = carNames.map { name -> Car(name = name) }
        _rounds = roundsInput.toInt()
    }

    fun runOneRound() {
        _cars = _cars.map { car ->
            car.move(numberGenerator.generateNumber())
        }
    }

    fun getCurrentState(): List<Pair<String, Int>> = _cars.map { car -> car.name to car.position }

    fun getWinners(): List<String> {
        val maxPosition = _cars.maxOfOrNull { it.position } ?: 0

        return _cars
            .filter { car -> car.position == maxPosition }
            .map { car -> car.name }
    }
}
