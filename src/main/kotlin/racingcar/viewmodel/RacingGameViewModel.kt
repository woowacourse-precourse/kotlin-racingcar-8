package racingcar.viewmodel

import racingcar.domain.Car
import racingcar.domain.GameValidator
import racingcar.domain.MoveStrategy
import racingcar.domain.RacingGame

class RacingGameViewModel(private val validator: GameValidator) {
    private lateinit var game: RacingGame
    private var raceCount: Int = 0

    fun setupGame(carNamesInput: String, raceCountInput: String) {
        validator.validateCarNames(carNamesInput)
        this.raceCount = validator.validateRaceCount(raceCountInput)

        val names = carNamesInput.split(",")
        val cars = names.map { Car(it) }
        this.game = RacingGame(cars)
    }

    fun getRaceCount(): Int = raceCount

    fun playOneRound(strategy: MoveStrategy): List<Car> {
        this.game = game.playRound(strategy)
        return game.cars
    }

    fun getWinnerNames(): List<String> = game.getWinners().map { it.name }
}
