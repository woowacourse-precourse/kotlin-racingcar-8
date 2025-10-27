package racingcar.adaptors.controller

import racingcar.application.parser.Parser
import racingcar.application.parser.StringToIntParser
import racingcar.application.parser.StringToSetParser
import racingcar.application.validator.Validator
import racingcar.domain.game.RacingGame
import racingcar.adaptors.view.InputView
import racingcar.adaptors.view.OutputView


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
        val carNames = parse(StringToSetParser(), readCarNames)
        val attemptCount = parse(StringToIntParser(), readAttemptCount)
        initRacingGame(carNames, attemptCount)
    }

    private fun <O> parse(parser: Parser<O>, input: String): O {
        return parser.parse(input)
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
        winnerResult(racingGame);
    }

    private fun winnerResult(racingGame: RacingGame) {
        val winnersResult: List<String> = racingGame.winnerResult()
        outputView.printWinner(winnersResult)
    }


}