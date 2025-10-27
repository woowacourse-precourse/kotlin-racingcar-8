package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
}

fun input(): Race {
    val cars = inputCars()
    val round = inputRound()
    return Race(round, cars)
}

private fun inputRound(): Int {
    println(Message.ROUND_GUIDE_MESSAGE)
    val roundInput = Console.readLine()
    val round = roundInput.toIntOrNull() ?: throw IllegalArgumentException(Message.ROUND_ERROR_MESSAGE)
    return round
}

private fun inputCars(): List<Car> {
    println(Message.RACING_CAR_NAME_GUIDE_MESSAGE)
    val carNames = Console.readLine().split(",")
    val cars = carNames.map {
        Car(it.trim())
    }
    return cars
}