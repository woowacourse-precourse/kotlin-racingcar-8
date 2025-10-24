package racingcar.view
import racingcar.Car

private const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
private const val INPUT_TRIAL_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val RESULT_HEADER_MESSAGE = "실행 결과"
private const val FINAL_WINNER_PREFIX = "최종 우승자 : "
private const val WINNER_DELIMITER = ", "
private const val CAR_PROGRESS_SEPARATOR = " : "
private const val POSITION_SYMBOL = "-"

object OutputView {
    fun printCarInputInstruction() {
        println(INPUT_CAR_NAMES_MESSAGE)
    }

    fun printRepeatNumInputInstruction() {
        println(INPUT_TRIAL_COUNT_MESSAGE)
    }

    fun printResultHeader() {
        println(RESULT_HEADER_MESSAGE)
    }
    fun printRaceProcess(currentCars: List<Car>) {
        currentCars.forEach {
            val progress = POSITION_SYMBOL.repeat(it.position)
            println("${it.carName}$CAR_PROGRESS_SEPARATOR$progress")
        }
        println()
    }
    fun printRaceWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(WINNER_DELIMITER) { it.carName }
        println("$FINAL_WINNER_PREFIX$winnerNames")
    }
}