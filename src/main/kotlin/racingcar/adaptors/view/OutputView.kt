package racingcar.adaptors.view

import racingcar.domain.game.Car
import racingcar.domain.game.RacingCar


interface OutputView {
    fun printCarNamesPrompt()

    fun printAttemptCountPrompt()

    fun printPlayerRoundResult(racingCars: Collection<Car>)

    fun printBlankLine()

    fun printRoundResultPrompt()

    fun printWinner(winnerResult: Collection<String>)

}