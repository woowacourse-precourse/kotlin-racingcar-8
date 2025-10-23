package racingcar.model

object RaceCountValidator {

    fun validateRaceCount(raceCount: String) {
        val count = raceCount.toIntOrNull()
        require(count != null) { "경주를 시도할 횟수는 숫자만 입력해주세요." }
        require(count > 0) { "경주를 시도할 횟수는 1 이상이어야 합니다."}
    }
}