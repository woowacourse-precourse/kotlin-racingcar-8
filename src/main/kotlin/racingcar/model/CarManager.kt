package racingcar.model

class CarManager(private val numberGenerator: NumberGenerator) {
    private val gameBoard: MutableMap<String, Int> = mutableMapOf()

    fun addCar(carList: List<String>) {
        if (carList.size != carList.toSet().size) {
            throw IllegalArgumentException("Duplicate name is not allowed")
        }
        carList.forEach { car ->
            gameBoard[car] = 0
        }
    }

    fun getCarLocation(car: String): Int {
        return gameBoard.getOrDefault(car, 0)
    }

    fun returnResult(): List<String> {
        val maxScore = gameBoard.values.maxOrNull() ?: 0
        return gameBoard.filterValues { it == maxScore }.keys.toList()
    }

    fun moveCar(car: String) {
        if (checkRaceCondition()) {
            gameBoard[car] = gameBoard.getOrDefault(car, 0) + 1
        }
    }

    private fun checkRaceCondition(): Boolean {
        return numberGenerator.generate() >= 4
    }
}