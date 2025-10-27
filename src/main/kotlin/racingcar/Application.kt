package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.all
import kotlin.text.all

val carNameAndTimeList = mutableMapOf<String, Int>()
var cars = mutableListOf<String>()
var movingTime: Int = 0
var randomNumber: Int = 0
var goalScore: Int = 0
var barStatus = mutableMapOf<String, Int>()

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

fun carNameList(): List<String> {
    return listOf(processCarNaming().joinToString(","))
}

fun validateNamesLength(names: List<String>) {
    if (!names.all { it.length <= 5 }) {
        throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
    }
    if (!names.all { it.isNotEmpty() }) {
        throw IllegalArgumentException("이름을 비워둘 수 없습니다.")
    }
}

 fun validateNamesDelimiter(names: List<String>) {
     if (!names.contains(",")) {
         throw IllegalArgumentException("구분자를 반드시 적어주세요.")
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

fun racing() {
    for (time in 1..movingTime) {
        carNameAssignmentStepTime()
        println("각 자동차마다 랜덤숫자 = ${carNameAssignmentStepTime()}")
    }
}

//fun racingBar(time: Int) {
//    for (barTime in 1..time) {
//        stepControl(barTime)
//    }
//}

fun stepControl() {
    for (i in 1..movingTime) {
        racingFourMoreRole()
    }
}

fun racingFourMoreRole() {
    for (carName in cars) {
        judgeFourMoreRole(carName)
    }
}

fun judgeFourMoreRole(car: String) {
    if (carNameAssignmentStepTime()[car]!! >= 4 ) {
        racingStatus()
        println("carNameAndTimeList = ${carNameAndTimeList}")
    }
}

fun racingStatus() {
    goalScore += 1
    for (carName in carNameAndTimeList.keys) {
        barStatus[carName] = goalScore
        barCreator(barStatus[carName])
    }
    println("goal $barStatus")
    println("goalScore = ${goalScore}")
}

fun barCreator(time: Int?) {
    val bar = "-"
    for (i in 1..time!!) {
        print(bar)
    }
    println()
}


fun carNameSetting() {
    for (carName in processCarNaming()) {
        cars.add(carName)
        carNameAndTimeList[carName] = 0
    }
    println(" 자동차 입력된 자동차이름  = ${ cars }")
}

fun carNameAssignmentStepTime(): MutableMap<String, Int> {
    for(car in cars) {
        randomNumber = pickRandomNumber()
        carNameAndTimeList[car] = randomNumber
    }
    return carNameAndTimeList
}

fun winner() {

}