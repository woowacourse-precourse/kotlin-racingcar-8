package racingcar.controller

import racingcar.model.Race
import racingcar.model.User
import racingcar.model.UserParser
import racingcar.validator.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller {
    fun run() {
        val users = getUsers()
        val round = getRound()
        val race = Race(users)

        OutputView.displayTitle()
        repeat(round) {
            playRound(race)
        }

        OutputView.displayWinners(race.getWinners())
    }

    private fun getUsers(): List<User> {
        val inputName = InputView.readParticipants()
        Validator.validateNotBlank(inputName)

        val userParser = UserParser(inputName)
        return userParser.getUserList()
    }

    private fun getRound(): Int {
        val inputRound = InputView.readRound()
        Validator.validateRoundInput(inputRound)

        return inputRound.toInt()
    }

    private fun playRound(race: Race) {
        race.play()
        OutputView.displayRoundResult(race.getScores())
    }
}