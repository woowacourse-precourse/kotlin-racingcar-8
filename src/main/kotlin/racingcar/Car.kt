package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car {
    val carsPosition: MutableMap<String, Int> = mutableMapOf()

    fun addCar(carNames: List<String>) {
        for (name in carNames) {
            carsPosition[name] = 0
        }
    }

    fun moveCar() {
        for (name in carsPosition.keys) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                carsPosition[name] = carsPosition[name]!! + 1
            }
        }
    }
}