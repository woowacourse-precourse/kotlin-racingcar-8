package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.Validator

class RacingController {
    fun start() {
        // 자동차 이름을 입력 받고 검증
        OutputView.printCarInputInstruction()
        val carNamesList = InputView.readCarNames()
        Validator.validateCarNames(carNamesList)

        // 반복 횟수를 입력 받고 검증
        OutputView.printRepeatNumInputInstruction()
        val repeatNumInput = InputView.readRepeatNum()
        Validator.validateRepeatNum(repeatNumInput)
        val repeatNum = repeatNumInput.toInt()

        // 자동차 객체를 생성
        val racingGame = RacingGame()
        val cars = carNamesList.map { carName -> Car(carName) }

        // 레이싱 진행
        OutputView.printResultHeader()
        val winners = racingGame.racing(cars, repeatNum)

        // 결과 출력
        OutputView.printRaceWinners(winners)
    }
}