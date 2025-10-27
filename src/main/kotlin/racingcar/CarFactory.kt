package racingcar

object CarFactory {

    fun createCars(rawNamesInput: String): List<Car> {
        val names = rawNamesInput.split(",")
        if (names.isEmpty()) {
            throw IllegalArgumentException("자동차 이름이 비어 있습니다.")
        }

        return names.map { Car(it) }
    }
}
