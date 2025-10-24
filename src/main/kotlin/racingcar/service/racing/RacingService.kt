package racingcar.service.racing

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.racing.AttemptCount
import racingcar.domain.racing.NumberPicker
import racingcar.domain.racing.Racing
import racingcar.domain.racing.Round

class RacingService(
    private val numberPicker: NumberPicker = NumberPicker(),
    private val racing: Racing = Racing()
) {
    fun race(input: String, cars: Cars): Racing {
        val attemptCount = AttemptCount.from(input)
        repeat(attemptCount.value) {
            val round = raceNewRound(cars)
            racing.saveRoundResults(round.roundResult)
        }
        racing.saveWinners(cars.getWinners())
        return racing
    }

    private fun raceNewRound(cars: Cars, round: Round = Round()): Round {
        for (car in cars.cars) {
            moveCar(car)
            round.saveRoundResult(car.name, car.distance)
        }
        return round
    }

    private fun moveCar(car: Car) {
        if (racing.canMove(numberPicker.getRandomNumber())) {
            car.move()
        }
    }
}