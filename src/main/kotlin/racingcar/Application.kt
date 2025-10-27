package racingcar

import racingcar.controller.RacingCarController
import racingcar.model.RacingCarService
import racingcar.view.RacingCarView

fun main() {
    // TODO: 프로그램 구현
    val racingCarService = RacingCarService()
    val racingCarView = RacingCarView()

    val racingCarController = RacingCarController(racingCarService, racingCarView)

    racingCarController.run()
}
