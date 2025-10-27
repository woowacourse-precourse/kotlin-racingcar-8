package racingcar

import racingcar.domain.Car
import racingcar.domain.RandomMoveDecider
import racingcar.service.RaceRound

fun main() {
    val names = listOf("pobi", "woni", "jun")
    val cars = names.map { Car(it) }

    val decider = RandomMoveDecider()
    val round = RaceRound(decider)

    println("===== 1 ROUND TEST =====")
    val results = round.runOnce(cars)

    cars.forEachIndexed { i, car ->
        println("${car.name} : ${"-".repeat(car.position)} (moved=${results[i]})")
    }
}
