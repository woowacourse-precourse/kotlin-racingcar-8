package racingcar.controller

import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController() {
    fun start() {
        // 자동차 이름
        val carNames = InputView.readCarNames()

        val cars = carNames.map { Car(it) }
        // 시도 횟수
        val tryCount = InputView.readTryCount()

        println("실행결과")
        // 반복하면서 자동차 이동 수행
        repeat(tryCount) {
            cars.forEach { car ->
                car.move()
            }
            //한 라운드 결과 출력
            OutputView.printRoundResult(cars)
            println()
        }

        OutputView.printWinner(cars)
    }
}