package racingcar.controller

import racingcar.model.RacingCarService
import racingcar.view.RacingCarView

class RacingCarController(
    val racingCarService: RacingCarService,
    val racingCarView: RacingCarView
) {
    fun run() {
        val carNamesInput = racingCarView.getCarNameInput()
        val carCountInput = racingCarView.getCarRaceCountInput()

        val names = racingCarService.parseCarNameInput(carNamesInput)
        val cars = racingCarService.getRacingPlayers(names)
        racingCarView.printCarRaceResultTitle()
        repeat(carCountInput) {
            racingCarService.playRace(cars)
            racingCarView.printCarRaceCurrentResult(cars)
        }
        val winner = racingCarService.getWinPlayers(cars)
        racingCarView.printCarRaceWinnerResult(winner)
    }
}