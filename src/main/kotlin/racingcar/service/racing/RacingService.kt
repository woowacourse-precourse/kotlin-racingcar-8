package racingcar.service.racing

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.racing.NumberPicker
import racingcar.domain.racing.Racing
import racingcar.domain.racing.Result
import racingcar.domain.racing.Round

class RacingService(
    private val numberPicker: NumberPicker = NumberPicker(),
) {
    fun race(input: String, cars: Cars): Result {
        val racing = Racing.from(input)

        repeat(racing.attemptCount.value) {
            val round = raceNewRound(cars, racing)
            racing.saveRoundResults(round.roundResult)
        }

        return Result(racing.roundResults, cars.getWinners())
    }

    private fun raceNewRound(cars: Cars, racing: Racing): Round {
        val round = Round()
        cars.cars.forEach { car ->
            moveCar(car, racing)
            round.saveRoundResult(car.name, car.distance)
        }
        return round
    }

    private fun moveCar(car: Car, racing: Racing) {
        if (racing.canMove(numberPicker.getRandomNumber())) {
            car.move()
        }
    }
}