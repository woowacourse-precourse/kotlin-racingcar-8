package racingcar.view

import racingcar.domain.game.Car


interface OutputView {
    fun printCarNamesPrompt()

    fun printAttemptCountPrompt()

    fun printPlayerRoundResult(cars: List<Car>)

    fun printBlankLine()

    fun printRoundResultPrompt()

}