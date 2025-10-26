package car.viewmodel

import car.model.MoveStrategy
import car.model.RacingGame

val ERROR_MESSAGE_CAR_NAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다."

class RacingViewModel (private val moveStrategy: MoveStrategy){
    private val game = RacingGame(moveStrategy)

    fun setupGame(carNames: List<String>) {
        validateCarNames(carNames)
        game.addCars(carNames)
    }

    private fun validateCarNames(carNames: List<String>) {
        require(carNames.all { it.length <= 5 }) { ERROR_MESSAGE_CAR_NAME_LENGTH }
    }

    fun playOneRound() {
        game.moveCars()
    }
}