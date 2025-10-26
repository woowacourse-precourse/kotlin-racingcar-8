package racingcar.model

import racingcar.util.Constants.POSITION_BAR
import racingcar.util.Constants.ZERO

class Car(val name: String) {
    private var position = ZERO

    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            position += 1
        }
    }

    fun getPosition(): Int = position
    fun getPositionBar(): String = POSITION_BAR.repeat(position)
}