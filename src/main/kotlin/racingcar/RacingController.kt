package racingcar

class RacingController {
    fun run() {
        val carNames = getValidCarNames()
        val attemptCount = getValidAttemptCount()

        val game = RacingGame(carNames)

        playGame(game, attemptCount)
        announceWinners(game)
    }

    private fun getValidCarNames(): List<String> {
        val carNames = InputView.readCarNames()
        InputValidator.validateCarNames(carNames)
        return carNames
    }

    private fun getValidAttemptCount(): Int {
        val attemptCount = InputView.readAttemptCount()
        InputValidator.validateAttemptCount(attemptCount)
        return attemptCount
    }

    private fun playGame(game: RacingGame, attemptCount: Int) {
        OutputView.printResultHeader()
        repeat(attemptCount) {
            game.playRound()
            OutputView.printRoundResult(game.getCurrentStatus())
        }
    }

    private fun announceWinners(game: RacingGame) {
        val winners = game.getWinners()
        OutputView.printWinners(winners)
    }
}