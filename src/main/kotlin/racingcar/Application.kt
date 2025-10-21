package racingcar
import camp.nextstep.edu.missionutils.Console as Console

fun main() {
    val inputController = InputController()

    View.inputName() // 이름 입력
    val carList = inputController.createCarList(Console.readLine()) // 자동차 리스트

    View.inputCount() // 움직임 값 입력
    val count = inputController.countToInt(Console.readLine()) // 움직임 값

    val carController = CarController(carList) // 자동차 컨트롤러
    View.movingResult(carController, count) // 실행 결과
    View.result(carController) // 최종 우승자

}
