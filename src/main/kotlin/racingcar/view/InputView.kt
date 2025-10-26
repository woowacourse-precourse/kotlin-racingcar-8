package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.Messages

object InputView {

    fun getCarNames() : List<String> {
        println(Messages.INPUT_CAR_NAMES)
        val input = Console.readLine()
        val carNames = input.split(',').map { it.trim() }

        return carNames
    }

    fun getTries() : String {
        println(Messages.INPUT_TRIES)
        val tries = Console.readLine()

        return tries
    }
}
