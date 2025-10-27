package racingcar.domain.car

class Car(
    val name: Name,
    private var _distance: Int = 0,
) {
    val distance: Int get() = _distance

    fun move() = _distance++
}