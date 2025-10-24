package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine
import racingcar.model.Car

class RacingCarView {
    fun getCarNameInput(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return readLine()
    }

    fun getCarRaceCountInput(): String {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()
    }

    fun printCarRaceResultTitle() {
        println("실행 결과")
    }

    fun printCarRaceCurrentResult(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
    }
}