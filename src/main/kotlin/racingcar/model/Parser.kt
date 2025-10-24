package racingcar.model

class Parser() {
    fun parseCarName(input: String): List<Car> {

        val parseInput = input.split(",")
        val cars = parseInput.map { Car(it) }

        return cars
    }
}
