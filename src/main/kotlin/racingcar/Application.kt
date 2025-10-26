package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.all
import kotlin.text.all

fun main() {
    // TODO: 프로그램 구현
    carForRacingJudge()
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

fun racingBar(time: Int) {
    for (barTime in 1..time) {
        barCreator(barTime)
    }
}

fun barCreator(time: Int) {
    val bar = "-"
    println()
    for (i in 1..time) {
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

fun carForRacingJudge() {
    for (time in carNameAssignmentStepTime().values) {
        judgeSingleCar(time)
    }
}

private fun judgeSingleCar(time: Int) {
    if (time >= 4) {
        return stepControl(time)
    }
    return stepControl(0)
}

fun stepControl(trigger: Int) {
    racingBar(trigger)
}

fun carNameAssignmentStepTime(): MutableMap<String, Int> {
    val carNameAndTimeList = mutableMapOf<String, Int>()
    for (carName in processCarNaming()) {
        carNameAndTimeList[carName] = randomNumber()
    }
    println("carNameAndTimeList $carNameAndTimeList")
    return carNameAndTimeList
}