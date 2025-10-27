package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getCarNameFromUser(): String = Console.readLine()
    fun getMovementTimeFromUser(): String = Console.readLine()
}