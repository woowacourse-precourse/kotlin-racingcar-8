package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    val carInput = readLine()
    val carList = carInput.split(",").map { name ->
        invalidCarValueCheck(name)
        Car(name)
    }
    val moveInput = readLine()
    invalidMoveValueCheck(moveInput)
    val moveCount = moveInput.toInt()
}

class Car(val name: String, var position: Int = 0) {
    fun move() {
        position++
    }
}

fun invalidCarValueCheck(input: String){
    if (input.isEmpty() && input.length > 5) {
        throw IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.")
    }
}

fun invalidMoveValueCheck(input: String){
    val count = input.toIntOrNull() ?: throw IllegalArgumentException("이동 횟수는 숫자여야 합니다.")
    if (count < 0) {
        throw IllegalArgumentException("이동 횟수는 0 이상이어야 합니다.")
    }
}
