package racingcar.controller

import racingcar.application.converter.Converter
import racingcar.application.converter.StringToIntConverter
import racingcar.application.converter.StringToListConverter
import racingcar.application.validator.Validator
import racingcar.domain.game.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class UserController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val carNameValidator: Validator,
) {
    fun run() {
        outputView.printCarNamesPrompt()
        val readCarNames = inputView.readCarNames()
        carNameValidator.validate(readCarNames)
        outputView.printAttemptCountPrompt()
        val readAttemptCount = inputView.readAttemptCount()
        val carNames = convert(StringToListConverter(), readCarNames)
        val attemptCount = convert(StringToIntConverter(), readAttemptCount)
        initRacingGame(carNames as List<String>, attemptCount as Int)
    }

    private fun convert(converter: Converter<Any>, input: String): Any {
        return converter.convert(input)
    }

    private fun initRacingGame(carNames: List<String>, attemptCount: Int) {
        val racingGame = RacingGame(carNames)
        playRacingGame(racingGame, attemptCount)
    }

    private fun playRacingGame(racingGame: RacingGame, attemptCount: Int) {
        for (attempt in 0 until attemptCount) {
            racingGame.playRound()
        }
    }

}