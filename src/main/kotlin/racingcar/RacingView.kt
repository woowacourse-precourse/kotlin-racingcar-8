package racingcar

import camp.nextstep.edu.missionutils.Console

object RacingView {
    fun getNamesFromUser(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return Console.readLine().split(",")
    }

    fun getAttemptFromUser(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toInt()
    }

    private fun showStatus(round: Round) {
        for (car in round) {
            println(car.status())
        }
    }

    fun showStatus(racing: Racing) {
        if (racing.totalRounds() <= 1) {
            return
        }
        println("실행 결과")
        for (round in racing.drop(1)) {
            showStatus(round)
            println()
        }
    }

    fun showWinner(racing: Racing) {
        val carNames = racing.getWinners().map { car ->
            car.name
        }
        println("최종 우승자 : ${carNames.joinToString(", ")}")
    }
}