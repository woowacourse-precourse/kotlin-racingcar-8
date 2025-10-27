package racingcar.view

import racingcar.domain.game.Car


interface OutputView {
    fun printCarNamesPrompt()

    fun printAttemptCountPrompt()

    fun printPlayerRoundResult(cars: Collection<Car>)

    fun printBlankLine()

    fun printRoundResultPrompt()

    fun printWinner(winnerResult: Collection<String>)

}