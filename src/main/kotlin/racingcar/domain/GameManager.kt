package racingcar.domain

import racingcar.io.InputMessageType
import racingcar.io.InputView
import racingcar.util.Parser

object CarFactory {
    fun createCars(
        reader: () -> String = {
            InputView.readNonEmptyLine(InputMessageType.CAR)
        },
    ): List<Car> {
        return Parser.splitWithDelimiters(reader()).map(::Car)
    }

    fun createRound(
        reader: () -> String = {
            InputView.readNonEmptyLine(InputMessageType.ROUND)
        },
    ): Int {
        return Parser.parseInt(reader()).let(Validator::validateRound)
    }
}

class GameManager(
    private val cars: List<Car> = CarFactory.createCars(),
    val maxRound: Int = CarFactory.createRound(),
) {
    fun playRound(): List<Car> {
        cars.forEach { car ->
            car.tryMove()
        }
        return cars
    }

    /** [racingcar.util.RandomGenerator.THRESHOLD]보다 멀거나 같은 거리를 이동한 차의 이름 리스트 반환 */
    fun findWinnerNames(): List<String> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: return emptyList()
        val result = cars.filter { it.position == maxPosition }.map { it.name }
        return result
    }
}
