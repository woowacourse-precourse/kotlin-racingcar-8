package car.viewmodel

import car.model.RacingGame

class RacingViewModel {
    private val game = RacingGame()

    fun setupGame(carNames: List<String>) {
        validateCarNames(carNames)
        game.addCars(carNames)
    }

    private fun validateCarNames(carNames: List<String>) {
        require(carNames.all { it.length <= 5 }) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }
}