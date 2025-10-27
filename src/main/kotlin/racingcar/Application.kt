package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.all
import kotlin.text.all

var cars = mutableListOf<String>()
var movingTime: Int = 0
var carRunStatus = mutableMapOf<String, Int>()

fun main() {
    // TODO: 프로그램 구현
    game()
}

fun game() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    carNameSetting()
    println("시도할 횟수는 몇 회인가요?")
    timeSetting()
    println()
    println("실행 결과")
    stepControl()
    winner()
}

fun input(): String {
    return Console.readLine()
}

fun processCarNaming(): List<String> {
    return input().split(",")
}

fun validateNamesLength(names: List<String>) {
    if (!names.all { it.length <= 5 }) {
        throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
    }
    if (!names.all { it.isNotEmpty() }) {
        throw IllegalArgumentException("이름을 비워둘 수 없습니다.")
    }
}

fun validateNamesType(names: List<String>) {
    for (name in names) {
        validateNamesCharType(name)
    }
}

private fun validateNamesCharType(name: String) {
    if (!name.all { it.isLetter() }) {
        throw IllegalArgumentException("이름은 알파벳만 입력 가능합니다.")
    }
}

fun pickRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

fun timeSetting() {
    val inputTime = input()
    movingTime = inputTime.toIntOrNull()
        ?: throw IllegalArgumentException("숫자만 가능합니다.")
    if (movingTime <= 0) {
        throw IllegalArgumentException("횟수는 1 이상이어야 합니다.")
    }
}

fun stepControl() {
    for (i in 1..movingTime) {
        racingFourMoreRole()
        currentResult()
    }
}

fun racingFourMoreRole() {
    for (carName in cars) {
        judgeFourMoreRole(carName)
    }
}

fun judgeFourMoreRole(car: String) {
    val randomNumber = pickRandomNumber()
    if (randomNumber >= 4) {
        val currentStatus = carRunStatus.getOrDefault(car, 0)
        carRunStatus[car] = currentStatus + 1
    }
}

fun currentResult() {
    for (carName in cars) {
        print("$carName : ")
        barCreator(carRunStatus[carName])
    }
    println()
}

fun barCreator(time: Int?) {
    val bar = "-"
    for (i in 1..time!!) {
        print(bar)
    }
    println()
}

fun carNameSetting() {
    val carNames = processCarNaming()
    validateNamesLength(carNames)
    validateNamesType(carNames)

    for (carName in carNames) {
        cars.add(carName)
        carRunStatus[carName] = 0
    }
}

fun winner() {
    val maxBar = carRunStatus.values.maxOrNull() ?: 0
    val winners = carRunStatus
        .filter { it.value == maxBar }
        .keys

    println("최종 우승자 : ${winners.joinToString(", ")}")
}