package racingcar

import camp.nextstep.edu.missionutils.Randoms


class Race(private val round: Int, private val cars: List<Car>, private val raceResult: RaceResult = RaceResult()) {
    init {
        require(round > 0) { Message.ROUND_ERROR_MESSAGE }
    }

    fun start(pickRandomNumber: () -> Int = { Randoms.pickNumberInRange(0, 9) }): RaceResult {
        playRound(pickRandomNumber)
        raceResult.setWinners(cars)
        return raceResult
    }

    private fun playRound(pickRandomNumber: () -> Int) {
        repeat(round) {
            moveCar(pickRandomNumber)
            raceResult.addRoundProgress(cars)
        }
    }

    private fun moveCar(pickRandomNumber: () -> Int) {
        cars.forEach { car ->
            car.move(pickRandomNumber())
        }
    }
}