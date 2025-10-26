package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomGenerator {
    const val MIN_VALUE = 0
    const val MAX_VALUE = 9
    const val THRESHOLD = 4

    /** 생성된 랜덤값과 THRESHOLD와의 대소관계에 따라 [Boolean]을 반환합니다. */
    fun isNotLessThanThreshold(): Boolean {
        val result = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)
        return result >= THRESHOLD
    }
}