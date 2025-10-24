package racingcar.domain.racing

import camp.nextstep.edu.missionutils.Randoms

class NumberPicker {
    fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN, MAX)
    }

    companion object {
        private const val MIN: Int = 0
        private const val MAX: Int = 9
    }
}