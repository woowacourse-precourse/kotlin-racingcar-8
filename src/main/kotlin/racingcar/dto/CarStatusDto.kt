package racingcar.dto

import racingcar.domain.car.Car

data class CarStatusDto(
    val name: String,
    val distance: Int
)

fun Car.toDto() = CarStatusDto(
    name = this.name.value,
    distance = this.distance
)