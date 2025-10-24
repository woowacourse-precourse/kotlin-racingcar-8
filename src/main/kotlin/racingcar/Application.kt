package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
    print(processCarNaming("pobi,zz"))
}

fun infoMessage() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
}

fun input(): String? {
    return Console.readLine()
}

fun output() {
}

fun processCarNaming(input: String): String {
    val carNames = listOf(input)
    return carNames.joinToString(",")
}