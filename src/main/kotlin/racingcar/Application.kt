package racingcar

import racingcar.domain.GameManager
import racingcar.io.OutputView

fun main() {
    val gameManager = GameManager()

    // 1. 라운드별 진행 및 출력
    repeat(gameManager.maxRound) {
        gameManager.playRound().forEach { car ->
            OutputView.printCarStatus(car)
        }
    }

    // 2. 최종 결과 출력
    OutputView.printWinners(gameManager.findWinnerNames())
}