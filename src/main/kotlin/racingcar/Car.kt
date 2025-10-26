package racingcar

class Car {
    val carsPosition: MutableMap<String, Int> = mutableMapOf()

    fun addCar(carNames: List<String>) {
        for (name in carNames) {
            carsPosition[name] = 0
        }
    }
}