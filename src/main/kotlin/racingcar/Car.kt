package racingcar

data class Car(
    val name: String,
    var distance: Int = 0
)

fun List<String>.toCars() = map { Car(it) }

fun List<Car>.maxDistance(): Int {
    var max = 0
    for (i in this) {
        if (i.distance > max) max = i.distance
    }

    return max
}
