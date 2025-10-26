package racingcar

data class AttemptingNumber(val value: Int) {
    init {
        require(value >= 0) { "시도 횟수는 음수일 수 없습니다." }
    }
}

data class Car(val name: String, val position: Int) {
    init {
        require(name.isNotEmpty()) { "자동차 이름은 한 글자 이상을 포함해야 합니다." }
        require(name.length <= NAME_LENGTH_LIMIT) { "자동차 이름은 5글자 이하여야 합니다." }
    }

    init {
        require(position >= START_POSITION) {
            "자동차의 위치($position)는 $START_POSITION 미만일 수 없습니다."
        }
    }

    fun moveForward(): Car = Car(name, position + 1)

    fun tryMoveForward(number: Int): Car {
        if (number >= MOVING_THRESHOLD) {
            return Car(name, position + MOVE_INCREMENT)
        }
        return this
    }

    fun status(): String {
        val path: String = "-".repeat(position)
        return "$name : $path"
    }

    companion object {
        const val START_POSITION = 0
        const val NAME_LENGTH_LIMIT = 5
        const val MOVE_INCREMENT = 1
        const val MOVING_THRESHOLD = 4

        fun withStartPosition(name: String): Car = Car(name, START_POSITION)
    }

}

fun List<Car>.tryMoveForward(numbers: List<Int>): List<Car> {
    require(numbers.size == this.size) { "숫자 수와 자동차 수가 동일해야합니다." }
    return zip(numbers).map { (car, number) ->
        car.tryMoveForward(number)
    }
}

fun List<Car>.showStatus() {
    for (car in this) {
        println(car.status())
    }
}

fun createUniqueCars(names: List<String>): List<Car> {
    val usedNames = mutableSetOf<String>()
    return names.map { name ->
        require(!usedNames.contains(name)) { "중복된 자동차 이름($name)은 허용되지 않습니다." }
        usedNames.add(name)
        Car.withStartPosition(name)
    }
}

fun main() {
    val cars = createUniqueCars(listOf("pobi", "woni", "jun"))
    val nextCars = cars.tryMoveForward(listOf(4, 0, 4))
    nextCars.showStatus()
}
