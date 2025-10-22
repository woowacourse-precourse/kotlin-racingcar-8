package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

class View {
    // 이름을 받을 때 나타나는 함수
    fun inputName(): String {
        println(INPUT_NAMES)
        return Console.readLine()
    }

    // 움직임 횟수를 받을 때 나타나는 함수
    fun inputCount(): String {
        println(INPUT_COUNT)
        return Console.readLine()
    }

    // 현재까지의 자동차 움직임을 나타내주는 함수
    fun currentMoving(currentMoving: List<Car>) {
        for (i in currentMoving) {
            println(i.name + " : " + MOVE_STRING.repeat(i.moves))
        }
        println()
    }

    // 어떻게 움직이는지를 나타내는 함수
    fun movingResult() {
        println()
        println(RESULT_STRING)

    }

    // 최종 우승자를 나타내는 함수
    fun result(winnerList: List<String>) {
        println(OUTPUT_STRING + " : " + winnerList.joinToString(", "))
    }

    companion object {
        const val INPUT_NAMES: String = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_COUNT: String = "시도할 횟수는 몇 회인가요?"
        const val RESULT_STRING: String = "실행 결과"
        const val OUTPUT_STRING: String = "최종 우승자"
        const val MOVE_STRING: String = "-"

    }
}