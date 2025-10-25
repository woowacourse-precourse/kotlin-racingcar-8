package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Game(private val cars: List<Car>) {
    fun play() {
        moveCars()
    }

    private fun moveCars() {
        cars.forEach { it.move(Randoms.pickNumberInRange(0,9)) }
    }
}