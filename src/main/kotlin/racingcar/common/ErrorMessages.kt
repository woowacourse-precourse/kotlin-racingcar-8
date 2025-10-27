package racingcar.common

object ErrorMessages {
    object CarName {
        const val BLANK = "자동차 이름은 공백일 수 없습니다."
        const val MORE_THEN_5 = "자동차 이름은 5자 이하여야 합니다."
    }

    object Attempt {
        const val BLANK = "시도 횟수는 공백일 수 없습니다."
        const val NEGATIVE = "시도 횟수는 음수일 수 없습니다."
        const val ZERO = "시도 횟수는 0일 수 없습니다."
        const val DOUBLE = "시도 횟수는 소수점을 가질 수 없습니다."
        const val NOT_INT = "시도 횟수는 양수여야 합니다."
    }
}
