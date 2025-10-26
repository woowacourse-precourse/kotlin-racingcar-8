package racingcar.view.domain

import racingcar.view.OutputMessages
import racingcar.view.repository.Output


object GuideView : Output {
    override fun consoleName() {
        println(OutputMessages.NAME_GUIDE)
    }

    override fun consoleAttempt() {
        println(OutputMessages.ATTEMPT_GUIDE)
    }
}