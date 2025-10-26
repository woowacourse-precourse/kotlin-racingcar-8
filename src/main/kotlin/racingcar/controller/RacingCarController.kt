package racingcar.controller

import racingcar.view.View

class RacingCarController(
    val view: View = View(),
    val inputController: InputController = InputController()
) {
    fun run() {
        val nameList = view.inputName() // 이름 입력
        val carList = inputController.createCarList(nameList) // 자동차 리스트
        val carController = CarController(carList)

        val moves = view.inputCount()// 움직임 값 입력
        val count = inputController.countToInt(moves) // 움직임 값

        view.movingResult() // 실행 결과
        repeat(count) {
            view.currentMoving(carController.currentMoving())
        }

        view.result(carController.winner())
    }
}