package racingcar.view

import racingcar.dto.CarStatusDto
import racingcar.dto.RacingResultDto
import racingcar.dto.RoundResultDto

object OutputView {
    private const val CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?"
    private const val RACING_RESULT = "실행 결과"
    private const val FINAL_WINNER = "최종 우승자 :"

    fun displayCarNamePrompt() {
        println(CAR_NAME_PROMPT)
    }

    fun displayAttemptCountPrompt() {
        println(ATTEMPT_COUNT_PROMPT)
    }

    fun displayResult(result: RacingResultDto) {
        println("\n$RACING_RESULT\n${formatRoundResults(result.rounds)}\n")
        println("$FINAL_WINNER ${formatWinners(result.winners)}")
    }

    private fun formatRoundResults(results: List<RoundResultDto>): String {
        return results.joinToString("\n\n") { roundResult ->
            formatRoundResult(roundResult.carRoundResults)
        }
    }

    private fun formatRoundResult(roundResult: List<CarStatusDto>): String {
        return roundResult.joinToString("\n") { car ->
            formatCarStatus(car)
        }
    }

    private fun formatCarStatus(car: CarStatusDto): String {
        return "${car.name} : ${"-".repeat(car.distance)}"
    }

    private fun formatWinners(winners: List<String>): String {
        return winners.joinToString(", ")
    }
}