package racingcar.service.racing

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.racing.AttemptCount
import racingcar.domain.racing.NumberPicker
import racingcar.domain.racing.RacingManager
import racingcar.dto.RacingResultDto
import racingcar.dto.RoundResultDto
import racingcar.dto.toDto

class RacingService {
    fun race(input: String, cars: Cars): RacingResultDto {
        val attemptCount = AttemptCount.from(input)
        val results = (1..attemptCount.value).map {
            playRound(cars)
        }

        return RacingResultDto(
            results,
            cars.getWinners().map { it.name.value }
        )
    }

    private fun playRound(cars: Cars): RoundResultDto {
        val results = cars.cars.map { car ->
            tryMoveCar(car)
            car.toDto()
        }
        return RoundResultDto(results)
    }

    private fun tryMoveCar(car: Car) {
        if (RacingManager.canMove(NumberPicker.getRandomNumber())) {
            car.move()
        }
    }
}