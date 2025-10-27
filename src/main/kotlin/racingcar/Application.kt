package racingcar

import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.validator.InputValidator
import racingcar.view.InputView

fun main() {
    val carNames = readCarNames()
    val rounds = readRounds()

    val cars = Cars.from(carNames)
    val game = RacingGame(cars, rounds)
    game.start()
}

private fun readCarNames(): List<String> {
    val input = InputView.readCarNames()
    return InputValidator.validateCarNames(input)
}

private fun readRounds(): Int {
    val input = InputView.readRounds()
    return InputValidator.validateRounds(input)
}