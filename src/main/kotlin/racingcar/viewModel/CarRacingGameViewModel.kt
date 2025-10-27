package racingcar.viewModel

import racingcar.model.Car
import racingcar.model.CarRacingGame

class CarRacingGameViewModel {

    private lateinit var game: CarRacingGame

    fun gameSetting(cars: List<Car>) {
        game = CarRacingGame(cars)
    }

    fun runAllGames(tryCount: Int): List<Map<String, String>> {
        val allGamesResult = mutableListOf<Map<String, String>>()

        repeat(tryCount) {
            game.runRace()
            allGamesResult.add(game.getCurrentCarDistances())
        }
        return allGamesResult
    }

    fun validateCarName(carNames: String): List<Car> {
        val carName = carNames.split(",").map { it.trim() }

        if (carName.toSet().size != carName.size) {
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
        }

        return carName.map { Car(it) }
    }

    fun validateTryCount(tryCountString: String): Int {
        val tryCount = tryCountString.toIntOrNull() ?: throw IllegalArgumentException("시도횟수가 올바르지 않습니다.")
        require(tryCount > 0) { "시도 횟수는 자연수로 제합됩니다." }

        return tryCount
    }

    fun getWinnerNames(): String {
        return game.getWinners().joinToString(", ")
    }
}