package racingcar

import camp.nextstep.edu.missionutils.Console
import kotlin.collections.all
import kotlin.text.all

fun main() {
    // TODO: 프로그램 구현
    print(validateNamesType())
}

fun infoMessage() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    println("실행 결과")
}

fun input(): String {
    return Console.readLine()
}

fun output() {

}

fun processCarNaming(): List<String> {
    val carNames = input().split(",")
    return listOf(carNames.joinToString(","))
}

fun validateNamesLength() {
    if (!processCarNaming().all { it.length <= 5 }) {
        throw IllegalArgumentException()
    }
    if (!processCarNaming().all { it.isNotEmpty() }) {
        throw IllegalArgumentException()
    }
}

fun validateNamesDelimiter() {
    if (!input().contains(",")) {
        throw IllegalArgumentException()
    }
}

fun validateNamesType() {
    val names = processCarNaming()
    for(name in names) {
        validateNamesCharType(name)
    }
}

private fun validateNamesCharType(name: String) {
    val nameChar = name.filter{ it != ',' }
    if (!nameChar.all { it.isLetter() }) {
        throw IllegalArgumentException()
    }
}

fun racingBar() {

}
