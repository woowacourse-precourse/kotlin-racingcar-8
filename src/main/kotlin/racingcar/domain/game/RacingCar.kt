package racingcar.domain.game

import racingcar.domain.port.NumberProvider
import racingcar.domain.rule.MoveRule

class RacingCar(override val name: String) : Car(name) {
    override fun move() {
        position++     // ⬅️ protected set 덕분에 가능
    }
}