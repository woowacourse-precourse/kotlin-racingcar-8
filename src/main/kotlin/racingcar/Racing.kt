package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

object Racing {
	private const val RANDOM_START_NUMBER = 0
	private const val RANDOM_END_NUMBER = 9
	private const val MIN_MOVE_VALUE = 4

	fun racingStart(cars: List<Car>, tryRound: Int) {
		repeat(tryRound) {
			roundStart(cars)
			OutputView.printRoundResult(cars)
		}

		val winners = getWinner(cars)

		OutputView.printWinners(winners)
	}

	private fun roundStart(cars: List<Car>) {
		cars.forEach { car ->
			val randomNumber = pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER)

			if (randomNumber >= MIN_MOVE_VALUE)
				car.moveForward()
		}
	}

	private fun getWinner(cars: List<Car>): List<Car> {
		val maxPosition = cars.maxOf { it.position }

		return cars.filter { it.position == maxPosition }
	}
}