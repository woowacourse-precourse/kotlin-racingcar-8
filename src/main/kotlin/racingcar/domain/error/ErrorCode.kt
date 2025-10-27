package racingcar.domain.error

object ErrorCode {
    const val NAMES_MUST_BE_COMMA_SEPARATED: String = "[ERROR] 이름은 쉼표(,)로 구분해 입력하세요."
    const val INVALID_CAR_NAME_LENGTH: String = "[ERROR] 자동차 이름은 1~5자여야 합니다."
    const val INVALID_ATTEMPT_COUNT_NUMBER: String = "[ERROR] 유효하지 않은 시도 횟수입니다. 숫자만 입력해 주세요."
    const val ATTEMPT_COUNT_MUST_BE_GREATER_THAN_ZERO: String = "[ERROR] 시도 횟수는 0보다 큰 양수여야 합니다."
    const val CAR_NAMES_MUST_BE_UNIQUE = "[ERROR] 자동차 이름은 중복될 수 없습니다."
    const val RACE_MUST_HAVE_PROGRESS = "[ERROR] 모든 자동차가 0칸 이동했습니다. 유효한 경주가 아닙니다."
}