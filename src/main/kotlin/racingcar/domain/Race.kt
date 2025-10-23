package racingcar.domain

import racingcar.util.RandomUtils.getRandomInt

class Race(val cars: List<Car>, val tryCount: Int) {
    fun run() {
        repeat(tryCount) {
            for (car in cars) {
                car.move(getRandomInt())
            }
        }
    }
}