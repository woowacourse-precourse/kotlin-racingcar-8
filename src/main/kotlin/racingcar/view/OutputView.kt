package racingcar.view

import racingcar.constant.OutputMessage

object OutputView {

    fun displayRoundResult(result: Map<String, Int>) {
        result.forEach { (name, score) ->
            println(OutputMessage.ROUND_RESULT.format(name, score))
        }
    }
}