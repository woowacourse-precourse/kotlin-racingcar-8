package racingcar.model

class RaceManager {
    private val cars = mutableListOf<Car>()
    private var raceCount: Int = 0

    fun setRaceCount(raceCount: Int) {
        this.raceCount = raceCount
    }

    fun getRaceCount(): Int = raceCount

    fun addSuffixToDuplicateNames(carNames: List<String>, duplicateNameIndexes: Map<String, Set<Int>>): List<String> {
        if (duplicateNameIndexes.isEmpty()) return carNames

        val result = carNames.toMutableList()
        duplicateNameIndexes.forEach { (name, indexes) ->
            renameDuplicateNames(name, indexes, result)
        }
        return result
    }

    private fun renameDuplicateNames(name: String, indexes: Set<Int>, result: MutableList<String>) {
        var suffix = 'A'
        indexes.forEach { index ->
            result[index] = "$name$suffix"
            suffix++
        }
    }

    fun createCar(carNames: List<String>) {
        carNames.map { cars.add(Car(it)) }
    }

    fun startRound() {
        cars.map { it.move() }
    }

    fun getCars(): List<Car> = cars

    fun calculateWinners(): List<String> {
        val maxWin = cars.maxOfOrNull { it.position }
        return cars.filter {
            it.position == maxWin
        }.map { it.name }
    }
}