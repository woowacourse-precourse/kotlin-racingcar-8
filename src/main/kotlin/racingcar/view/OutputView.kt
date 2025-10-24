package racingcar.view
import racingcar.Car

object OutputView {
    fun printCarInputInstruction() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printRepeatNumInputInstruction() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printResultHeader() {
        println("실행 결과")
    }
    fun printRaceProcess(currentCars: List<Car>) {
        currentCars.forEach { println("${it.carName} : ${"-".repeat(it.position)}") }
        println()
    }

    fun printRaceWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.carName }
        println("최종 우승자 : $winnerNames")
    }
}