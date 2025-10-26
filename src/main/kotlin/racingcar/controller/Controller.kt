package racingcar.controller

import racingcar.view.InputView
import racingcar.model.RacingGame
import racingcar.view.OutputView
import racingcar.validator.Validator

class Controller {
    fun run() {
        val carNamesInput = InputView.getCarNames()
        val triesInput = InputView.getTries()

        Validator.validateCarNames(carNamesInput)
        val tries = Validator.validateTries(triesInput)

        val game = RacingGame(carNamesInput)

        OutputView.showRacingStart()
        repeat(tries) {
            val roundResult = game.playRound()
            OutputView.showRoundResult(roundResult)
        }

        val winners = game.getWinners()
        OutputView.showWinners(winners)
    }
}