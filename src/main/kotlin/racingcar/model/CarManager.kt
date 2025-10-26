package racingcar.model

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class CarManager {
    private val carList: MutableSet<String> = mutableSetOf()
    private val gameBoard: MutableMap<String, Int> = mutableMapOf()

    fun addCar(cars: List<String>) {
        for (car in cars) {
            carList.add(car)
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
        return pickNumberInRange(0, 9) >= 4
    }
}