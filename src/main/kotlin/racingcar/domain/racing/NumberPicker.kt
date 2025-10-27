package racingcar.domain.racing

import camp.nextstep.edu.missionutils.Randoms

object NumberPicker {
    private const val MIN: Int = 0
    private const val MAX: Int = 9

    fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN, MAX)
    }
}