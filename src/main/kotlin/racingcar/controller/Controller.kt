package racingcar.controller

import racingcar.model.Race
import racingcar.model.UserParser
import racingcar.validator.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller {
    fun run() {
        val inputName = InputView.readParticipants()
        Validator.validateNotBlank(inputName)

        val userParser = UserParser(inputName)

        val inputRound = InputView.readRound()
        Validator.validateRoundInput(inputRound)
        val round = inputRound.toInt()

        val race = Race(userParser.getUserList())

        OutputView.displayTitle()
        repeat(round) {
            race.play()
            OutputView.displayRoundResult(race.getScores())
        }
        OutputView.displayWinners(race.getWinners())
    }
}