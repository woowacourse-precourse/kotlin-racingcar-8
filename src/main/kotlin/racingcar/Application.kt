package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.MoveStrategy
import racingcar.domain.RacingGameValidator
import racingcar.view.RacingGameView
import racingcar.viewmodel.RacingGameViewModel

fun main() {
    val gameView = RacingGameView(
        viewModel = RacingGameViewModel(RacingGameValidator),
        moveStrategy = MoveStrategy { Randoms.pickNumberInRange(0, 9) >= 4 }
    )
    gameView.start()
}
