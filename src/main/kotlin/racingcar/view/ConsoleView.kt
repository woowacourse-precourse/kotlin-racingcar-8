package racingcar.view

import camp.nextstep.edu.missionutils.Console.readLine

object ConsoleView {

    fun inputCarNames(): String {
        println("경주할 자동차 이름을 입력하세요,(이름은 쉼표(,) 기준으로 구분")
        return readLine()
    }

    fun inputTryCount(): String {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()
    }

    fun showRaceProgress(printHeader: Boolean) {
        if (printHeader) println("실행 결과")

        // 반복문 구현 필요 [아래 형태로 출력]
        println("이름 : ---")

        println()
    }

    fun showRaceWinner() {
        println("최종 우승자 : ")
    }
}