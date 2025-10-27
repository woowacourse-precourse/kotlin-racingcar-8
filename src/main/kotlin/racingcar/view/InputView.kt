package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ROUNDS_PROMPT = "시도할 횟수는 몇 회인가요?"

    fun readCarNames(): String {
        println(CAR_NAMES_PROMPT)
        return Console.readLine()
    }

    fun readRounds(): String {
        println(ROUNDS_PROMPT)
        return Console.readLine()
    }
}