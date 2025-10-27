package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getInputCarNames(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNamesInput = Console.readLine()

        return carNamesInput
    }

    fun getInputRound(): String {
        println("시도할 횟수는 몇 회인가요?")
        val roundInput = Console.readLine()

        return roundInput
    }
}