package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNamesInput = Console.readLine()

    validateCarNames(carNamesInput)

    println("시도할 횟수는 몇 회인가요?")
    val tryCountInput = Console.readLine()
}

private fun validateCarNames(carNamesInput: String?) {
    val names = carNamesInput?.split(",")
        ?: throw IllegalArgumentException("입력이 없습니다.")

    for (name in names) {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름이 비었습니다.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("이름이 5자를 초과하였습니다.")
        }
    }
}
