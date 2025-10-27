package racingcar.controller

import racingcar.application.converter.Converter
import racingcar.application.converter.StringToIntConverter
import racingcar.application.converter.StringToListConverter
import racingcar.application.converter.StringToSetConverter
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
        val carNames = convert(StringToSetConverter(), readCarNames)
        val attemptCount = convert(StringToIntConverter(), readAttemptCount)
        initRacingGame(carNames, attemptCount )
    }

    private fun <O> convert(converter: Converter<O>, input: String): O {
        return converter.convert(input)
    }

    private fun initRacingGame(carNames: Collection<String>, attemptCount: Int) {
        val racingGame = RacingGame(carNames)
        playRacingGame(racingGame, attemptCount)
    }

    private fun playRacingGame(racingGame: RacingGame, attemptCount: Int) {
        outputView.printRoundResultPrompt();
        for (attempt in 0 until attemptCount) {
            val cars = racingGame.playRound()
            outputView.printPlayerRoundResult(cars);
            outputView.printBlankLine();
        }
        winnerResult(racingGame, attemptCount);
    }

    private fun winnerResult(racingGame: RacingGame, count: Int) {
        val winnersResult: List<String> = racingGame.winnerResult()
        outputView.printWinner(winnersResult)
    }


}