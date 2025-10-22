package racingcar.view

import racingcar.view.CliText.PROMPT_CAR_NAMES
import racingcar.view.CliText.PROMPT_ROUND_COUNT

class ConsoleOutputView : OutputView {
    override fun printCarNamesPrompt() {
        println(PROMPT_CAR_NAMES)
    }

    override fun printAttemptCountPrompt() {
        println(PROMPT_ROUND_COUNT)
    }
}



