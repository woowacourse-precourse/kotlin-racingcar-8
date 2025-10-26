package racingcar.model

import racingcar.view.OutputView

class RacingGame (private val cars: List<Car>, private val count: Int){
    fun startGame() {
        println("실행 결과")
        repeat(count) {
            playRound()
            OutputView.printRoundResult(cars)
        }
    }

    private fun playRound() {
        cars.forEach{ it.move() }
    }

    private fun judgeResult(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}