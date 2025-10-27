package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carInput = readLine()
    val carList = carInput.split(",").map { name ->
        invalidCarValueCheck(name)
        Car(name)
    }
    val moveInput = readLine()
    invalidMoveValueCheck(moveInput)
    val moveCount = moveInput.toInt()

    println("실행 결과")
    for (i in 0 until moveCount) {
        moveCars(carList)
        printProgress(carList)
        println()
    }

    raceResult(carList)
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

fun moveCars(carList: List<Car>) {
    carList.forEach { car ->
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if(randomNumber >= 4) {
            car.move()
        }
    }
}

fun printProgress(carList: List<Car>){
    carList.forEach { car ->
        print("${car.name} : ")
        for(i in 0 until car.position) {
            print("-")
        }
        println()
    }
}

fun raceResult(carList: List<Car>){
    val maxPosition = carList.maxOf { it.position }
    val winners = carList.filter { it.position == maxPosition }
    val winnerNames = winners.joinToString(", ") { it.name }
    println("최종 우승자 : $winnerNames")
}