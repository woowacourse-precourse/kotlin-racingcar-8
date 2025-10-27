package racingcar

fun main() {
    val carNames = getValidatedCarNames()
    val attemptCount = getValidatedAttemptCount()

    val racingGame = RacingGame(carNames)
    runRace(racingGame, attemptCount)
    displayWinners(racingGame)
}

private fun getValidatedCarNames(): List<String> {
    val carNames = InputView.readCarNames()
    Validator.validateCarNames(carNames)
    return carNames
}

private fun getValidatedAttemptCount(): Int {
    val attemptCount = InputView.readAttemptCount()
    Validator.validateAttemptCount(attemptCount)
    return attemptCount
}

private fun runRace(racingGame: RacingGame, attemptCount: Int) {
    OutputView.printResultHeader()
    val raceResults = racingGame.race(attemptCount)
    raceResults.forEach { roundResult ->
        OutputView.printRaceRound(roundResult)
    }
}

private fun displayWinners(racingGame: RacingGame) {
    val winners = racingGame.getWinners()
    OutputView.printWinners(winners)
}
