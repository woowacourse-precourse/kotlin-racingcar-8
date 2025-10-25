package racingcar.model

import racingcar.util.InputValidator.validateCarNames
import racingcar.util.InputValidator.validateRoundCount
import racingcar.util.NumberGenerator
import racingcar.util.RandomNumberGenerator

class RacingGame(
    private val numberGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    private var _cars: LinkedHashMap<Int, Car> = LinkedHashMap()

    private var _rounds: Int = 0
    val rounds: Int
        get() = _rounds

    fun setup(carNamesInput: String, roundsInput: String) {
        val carNames = carNamesInput.split(",")

        validateCarNames(carNames)
        validateRoundCount(roundsInput)

        carNames.forEachIndexed { index, name ->
            _cars[index] = Car(name = name)
        }
        _rounds = roundsInput.toInt()
    }

    fun runOneRound() = _cars.values.forEach { car ->
        car.move(numberGenerator.generateNumber())
    }

    fun getCurrentState(): List<Pair<String, Int>> = _cars.values.map { car -> car.name to car.position }

    fun getWinners(): List<String> {
        val maxPosition = _cars.values.maxOfOrNull { it.position } ?: 0

        return _cars
            .filter { car -> car.value.position == maxPosition }
            .map { car -> car.value.name }
    }
}
