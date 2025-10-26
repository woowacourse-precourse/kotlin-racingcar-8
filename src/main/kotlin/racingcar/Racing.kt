package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing(val list: List<Car>, val count: Int) {
    fun play() {}

    private fun go() {
        list.forEach {
            if (Randoms.pickNumberInRange(0, 9) >= 4) it.distance++
        }
    }

    private fun printState() {
        list.forEach {
            println("${it.name} : ${"-".repeat(it.distance)}")
        }
        println()
    }

    private fun printWinner() {}
}
