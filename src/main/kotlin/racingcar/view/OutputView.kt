package racingcar.view

import racingcar.model.Car

object OutputView {

    fun printPerRound(cars: List<Car>) {
        val stringBuilder = StringBuilder()
        cars.map { it ->
            stringBuilder.append("${it.name} : ")
            repeat(it.position, {
                stringBuilder.append("-")
            })
            stringBuilder.append("\n")
        }
        println(stringBuilder.toString())
    }
}