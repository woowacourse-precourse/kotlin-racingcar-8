package racingcar.view

import racingcar.domain.Car
import kotlin.math.PI

object ResultView {
    const val BAR = "-"

    fun printFirstResult(){
        println()
        println("실행 결과")
    }

    fun printRaceResult(car: Car){
        val positionBar = BAR.repeat(car.position)

        println("${car.name} : $positionBar")
    }

    fun printFinalWinner(cars: List<Car>, maxPosition: Int){
        val winners :MutableList<String> = mutableListOf()

        for (car in cars){
            if (car.position == maxPosition){
                winners += car.name
            }
        }

        val winnersName = winners.joinToString(", ")

        println("최종 우승자 : $winnersName")
    }
}
