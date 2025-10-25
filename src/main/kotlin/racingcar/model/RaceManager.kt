package racingcar.model

class RaceManager {
    private val cars = mutableListOf<Car>()
    private var raceCount: Int = 0

    fun setRaceCount(raceCount: Int) {
        this.raceCount = raceCount
    }

    fun getRaceCount(): Int = raceCount

    fun addSuffixToDuplicateNames(carNames: List<String>, duplicateNameAndIndex: Map<String, Set<Int>>): List<String> {
        if (duplicateNameAndIndex.isEmpty()) return carNames

        val result = carNames.toMutableList()
        duplicateNameAndIndex.forEach { (name, indexes) ->
            var suffix = 'A'
            indexes.forEach { index ->
                result[index] = "$name$suffix"
                suffix++
            }
        }
        return result
    }

    fun createCar(carNames: List<String>) {
        carNames.map { cars.add(Car(it)) }
    }

    fun startRound() {
        cars.map { it.move() }
    }

    fun getCars(): List<Car> = cars

}