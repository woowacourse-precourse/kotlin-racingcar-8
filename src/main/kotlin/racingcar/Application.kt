package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun getCarNamesList(): List<String> {
    val carNamesList = readLine().split(",")
    return carNamesList
}

fun getRepeatNum(): Int {
    val repeatNum = readLine().toIntOrNull()?: 0
    return repeatNum
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNamesList = getCarNamesList()
    println("시도할 횟수는 몇 회인가요?")
    val repeatNum = getRepeatNum()
}