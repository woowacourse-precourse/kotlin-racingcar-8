package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine
import racingcar.domain.Car
import racingcar.domain.RacingGame

object ConsoleView {

    fun inputCarNames(): String {
        println("경주할 자동차 이름을 입력하세요,(이름은 쉼표(,) 기준으로 구분")
        return readLine()
    }

    fun inputTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine().toInt()
    }

    fun showRaceHeader() {
        println("실행 결과")
    }

    fun showRaceProgress(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.score)}")
        }
        println()
    }

    fun showRaceWinner(racingGame: RacingGame) {
        val winners = racingGame.winner()
        println("최종 우승자 : ${winners.joinToString(", ") {it.name}}")
    }
}