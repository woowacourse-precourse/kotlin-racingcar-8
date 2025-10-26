package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Game(private val cars: List<Car>) {
    fun play() {
        moveCars()
        showAllCarsProgress()
    }

    private fun moveCars() {
        cars.forEach { it.move(Randoms.pickNumberInRange(0,9)) }
    }

    private fun showAllCarsProgress() {
        cars.forEach { it.showCurrentProgress() }
        println()
    }

    private fun getBestScore() : Int {
        return cars.maxOf { it.getScore() }
    }

    fun showWinners() {
        val maxScore = getBestScore()
        val winners = cars.filter { it.getScore() == maxScore }.map { it.getName() }

        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}