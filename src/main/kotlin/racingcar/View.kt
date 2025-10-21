package racingcar

class View {
    companion object {
        // 이름을 받을 때 나타나는 함수
        fun inputName() {
            println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        }

        // 움직임 횟수를 받을 때 나타나는 함수
        fun inputCount() {
            println("시도할 횟수는 몇 회인가요?")
        }

        // 어떻게 움직이는지를 나타내는 함수
        fun movingResult(carController: CarController, count: Int) {
            println()
            println("실행 결과")
            repeat(count) {
                carController.carMoving()
                carController.currentMoving()
                println()
            }
        }

        // 최종 우승자를 나타내는 함수
        fun result(carController: CarController) {
            println("최종 우승자 : ${carController.winner().joinToString(", ")}")
        }
    }
}