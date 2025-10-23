package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun getCarNamesList(): List<String> {
    val carNamesList = readLine().split(",")
    validateCarNames(carNamesList)
    return carNamesList
}

fun getRepeatNum(): Int {
    val repeatNum = readLine()
    validateRepeatNum(repeatNum)
    return repeatNum.toInt()
}


fun validateCarNames(carNames: List<String>): Unit {
    require(carNames.isNotEmpty()) {"최소 한 대 이상의 자동차 이름이 필요합니다."}
    carNames.forEach {
        require(it.isNotBlank()) {"자동차 이름은 빈 문자열일 수 없습니다."}
        require(it.length <= 5) {"자동차 이름은 5글자를 초과할 수 없습니다."}
    }
}
fun validateRepeatNum(repeatNum: String) {
    require(repeatNum.isNotEmpty()) {"시도 횟수는 빈 문자열일 수 없습니다."}
    val number = repeatNum.toIntOrNull()?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
    require(number > 0) {"시도 횟수는 1 이상의 정수여야 합니다."}
}

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNamesList = getCarNamesList()
    println("시도할 횟수는 몇 회인가요?")
    val repeatNum = getRepeatNum()
}