package car.viewmodel

import car.model.Car
import car.model.MoveStrategy
import car.model.RacingGame

val ERROR_MESSAGE_CAR_NAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다."
val ERROR_MESSAGE_DUPLICATE_CAR_NAME = "자동차 이름이 중복될 수 없습니다."
val ERROR_MESSAGE_ZERO_COUNT = "횟수는 1회 이상 입력해야 합니다."

class RacingViewModel (private val moveStrategy: MoveStrategy){
    private val game = RacingGame(moveStrategy)
    // 게임 설정(차 이름)
    fun setupGame(carNames: List<String>) {
        validateCarNames(carNames)
        game.addCars(carNames)
    }
    // 게임 진행 여부 판단(횟수)
    fun coutninueGame(roundCount: Int) {
        val count= validateRoundCount(roundCount)
        return count
    }

    fun playOneRound() {
        game.moveCars()
    }

    fun getCurrentStatus(): List<Car> {
        return game.getCars()
    }

    fun getWinners(): List<String> {
        return game.getWinners()
    }

    private fun validateCarNames(carNames: List<String>) {
        require(carNames.all { it.length <= 5 }) { ERROR_MESSAGE_CAR_NAME_LENGTH }
        require(carNames.size == carNames.toSet().size) { ERROR_MESSAGE_DUPLICATE_CAR_NAME }
    }

    private fun validateRoundCount(roundCount: Int) {
        require(roundCount >= 1) { ERROR_MESSAGE_ZERO_COUNT }
    }
}