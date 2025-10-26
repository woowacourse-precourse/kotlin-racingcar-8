package racingcar.view.domain

import racingcar.view.repository.Input
import camp.nextstep.edu.missionutils.Console


object InputView : Input {
    override fun console(): String = Console.readLine()
}