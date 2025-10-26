package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.all
import kotlin.text.all

fun main() {
    // TODO: 프로그램 구현

}

var movingTime: Int = 0

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
    return input().split(",")
}

fun carNameList(): List<String> {
    return listOf(processCarNaming().joinToString(","))
}

fun validateNamesLength() {
    if (!carNameList().all { it.length <= 5 }) {
        throw IllegalArgumentException()
    }
    if (!carNameList().all { it.isNotEmpty() }) {
        throw IllegalArgumentException()
    }
}

fun validateNamesDelimiter() {
    if (!input().contains(",")) {
        throw IllegalArgumentException()
    }
}

fun validateNamesType() {
    val names = carNameList()
    for (name in names) {
        validateNamesCharType(name)
    }
}

private fun validateNamesCharType(name: String) {
    val nameChar = name.filter { it != ',' }
    if (!nameChar.all { it.isLetter() }) {
        throw IllegalArgumentException()
    }
}

fun racingBar(turn: Int) {
    val bar = "-"
    for (i in 1..turn) {
        print(bar)
    }
}

fun randomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

fun turnTime(): Int {
    return input().toInt()
}

fun racingRole(): Boolean {
    return randomNumber() >= 4
}

fun racingJudge() {
    for (carName in carNameList()) {
        judgeSingleCar(carName)
    }
}

private fun judgeSingleCar(carName: String) {
    if (carNameAssignmentStepTime().getValue(carName) >= 4) {
        return gameControl()
    }
    if (carNameAssignmentStepTime().getValue(carName) < 4) {
        return stop()
    }
}

fun stop() {

}

fun gameControl() {
    for (time in 1..turnTime()) {
        movingTime += 1
        racingBar(movingTime)
    }
}

fun carNameAssignmentStepTime(): MutableMap<String, Int> {
    val carNamesList = mutableMapOf<String, Int>()
    for (carName in processCarNaming()) {
        carNamesList[carName] = randomNumber()
        print(carNamesList)
    }
    return carNamesList
}