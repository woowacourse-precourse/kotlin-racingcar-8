package racingcar.model

class FinalWinner {
    fun findWinners(cars: List<Car>): List<String> {

        val maxWinner = cars.maxByOrNull { it.position }
        val winnerPosition = maxWinner?.position
        val jointWinners = cars.filter { it.position == winnerPosition }
        val winners = jointWinners.map { it.name }

        return winners
    }
}