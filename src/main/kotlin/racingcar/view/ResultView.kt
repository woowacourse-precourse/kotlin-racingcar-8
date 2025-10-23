package racingcar.view

import racingcar.domain.Car

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

    fun printFinalWinner(winners: List<String>){
        val winnersName = winners.joinToString(", ")

        println("최종 우승자 : $winnersName")
    }
}
