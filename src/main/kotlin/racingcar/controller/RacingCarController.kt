package racingcar.controller

import racingcar.model.Number
import racingcar.model.Race
import racingcar.util.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        val carNames = inputCarNames()
        val attemptCount = inputAttemptCount()
        val race = Race(carNames, Number())

        playGame(race, attemptCount)
        announceWinners(race)
    }

    private fun announceWinners(race: Race) {
        val maxPosition = race.getCars().maxOf { it.getPosition() }
        val winners = race.getCars()
            .filter { it.getPosition() == maxPosition }
            .map { it.name }

        outputView.printWinner(winners)
    }

    private fun playGame(race: Race, attemptCount: Int) {
        outputView.printHeader()

        repeat(attemptCount) {
            race.play()
            outputView.printRoundResult(race.getCars())
        }
    }

    private fun inputAttemptCount(): Int {
        val input = inputView.attemptInputView()
        return Validator.attemptValidator(input)
    }

    private fun inputCarNames(): List<String> {
        val input = inputView.carNameInputView()
        return Validator.nameValidate(input)
    }
}