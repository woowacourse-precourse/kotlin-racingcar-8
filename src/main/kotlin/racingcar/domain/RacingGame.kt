package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.OutputView

class RacingGame(private val cars: Cars, private val rounds: Int) {

    fun start() {
        OutputView.printResultHeader()
        repeat(rounds) {
            playRound()
        }
        announceWinners()
    }

    private fun playRound() {
        cars.moveAll { car ->
            val randomValue = generateRandomValue()
            car.move(randomValue)
        }
        OutputView.printRoundResult(cars.getCarStatus())
    }

    private fun announceWinners() {
        val winners = cars.findWinners()
        OutputView.printWinners(winners)
    }

    private fun generateRandomValue(): Int {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
    }

    companion object {
        private const val MIN_RANDOM_VALUE = 0
        private const val MAX_RANDOM_VALUE = 9
    }
}