package racingcar.model

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.Messages

class Car(private val name: String) {
    private var distance: Int = 0

    init {
        require(name.trim().isNotEmpty()) { Messages.NOT_EMPTY_NAME}
        require(name.length <= MAX_NAME_LENGTH) { Messages.NOT_BIGGER_THAN_FIVE }
    }

    fun move() {
        if (pickNumberInRange(0, 9) >= 4) {
            distance++
        }
    }

    fun getDistance() = distance

    fun getName() = name

    companion object {
        const val MAX_NAME_LENGTH = 5
    }

}