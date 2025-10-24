package racingcar.domain

import racingcar.io.InputMessageType
import racingcar.io.InputView
import racingcar.util.Parser

object CarFactory {
    /** 콘솔에서 사용자 입력을 받아 자동차 객체 리스트[GameManager.cars]를 생성 */
    fun createCars(
        reader: () -> String = {
            InputView.readNonEmptyLine(InputMessageType.CAR)
        },
    ): List<Car> {
        return Parser.splitWithDelimiters(reader()).map(::Car)
    }

    /** 콘솔에서 사용자 입력을 받아 게임의 최대 라운드 수[GameManager.maxRound]를 생성 */
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
    /** 한 턴 동안 각 [Car]의 전진을 시도하고, 그 결과를 반환 */
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
