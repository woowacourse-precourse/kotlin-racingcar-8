package racingcar.model

class FinalWinner {
    fun findWinners(cars: List<Car>): String {

        val maxWinner = cars.maxBy { it.position }.position
        val winners = cars.filter { it.position == maxWinner }

        return winners.joinToString(",")
    }
}