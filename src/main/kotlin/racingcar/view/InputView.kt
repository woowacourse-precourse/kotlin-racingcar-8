package calculator.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getCarNames() : List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        val carNames = input.split(',')

        return carNames
    }
}
