package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.validator.CarValidator
import racingcar.model.validator.RoundCountValidator

class InputView {
    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carsInput = Console.readLine()

        return CarValidator.parse(carsInput)
    }

    fun readRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val countInput = Console.readLine()

        return RoundCountValidator.validate(countInput)
    }
}