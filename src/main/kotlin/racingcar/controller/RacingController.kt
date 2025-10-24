package racingcar.controller

import racingcar.validateRepeatNum
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.*

class RacingController {
    fun start() {
        // 자동차 이름을 입력 받고 검증
        OutputView.printCarInputInstruction()
        val carNamesList = InputView.readCarNames()
        validateCarNames(carNamesList)

        // 반복 횟수를 입력 받고 검증
        OutputView.printRepeatNumInputInstruction()
        val repeatNumInput = InputView.readRepeatNum()
        validateRepeatNum(repeatNumInput)
        val repeatNum = repeatNumInput.toInt()

        // 자동차 객체를 생성
        val cars = carNamesList.map { carName -> Car(carName) }

        // 레이싱 진행
        OutputView.printResultHeader()
        val winners = racing(cars, repeatNum)

        // 결과 출력
        OutputView.printRaceWinners(winners)
    }
}