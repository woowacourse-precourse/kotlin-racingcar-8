package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

object InputView {
	fun readInput(): Pair<String, String> {
		println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

		val names = readLine()

		println("시도할 횟수는 몇 회인가요?")

		val tryCount = readLine()

		return (names to tryCount)
	}
}