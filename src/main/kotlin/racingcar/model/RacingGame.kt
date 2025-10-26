package racingcar.model

class RacingGame (private val cars: List<Car>, private val count: Int){
    fun startGame() {
        repeat(count) {
            playRound()
        }
    }

    private fun playRound() {
        cars.forEach{ it.move() }
    }
}