package racingcar.dto

data class RacingResultDto(
    val rounds: List<RoundResultDto>,
    val winners: List<String>
)