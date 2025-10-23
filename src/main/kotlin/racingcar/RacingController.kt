package racingcar

import racingcar.view.InputView

class RacingController {
    fun run() {
        val carName = InputView().getCarNameFromUser()
        val carNames = Separator().separateName(carName)
        InputValidator().validateCarName(carNames)
    }
}