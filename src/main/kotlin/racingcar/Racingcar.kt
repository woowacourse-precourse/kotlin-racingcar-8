package racingcar

import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.util.CarNameParser
import racingcar.util.Validator
import racingcar.view.ConsoleView

class Racingcar {
    fun run() {
        val carNamesInput = ConsoleView.inputCarNames()

        val carNames = CarNameParser.parse(carNamesInput)
        Validator.validateCarNames(carNames)
        val cars = carNames.map { Car(it) }

        val rounds = ConsoleView.inputTryCount()
        Validator.validateRoundCheck(rounds)

        val racingGame = RacingGame(cars)
        racingGame.play(rounds)

        ConsoleView.showRaceWinner(racingGame)
    }
}