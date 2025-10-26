package racingcar.domain

class Judge {
    fun judgeWinner(gameResult: List<Car>): List<String> {
        val winners = mutableListOf<String>()

        var maxDistance = 0
        for(cars in gameResult) {
            if(cars.distance == maxDistance) winners.add(cars.name)
            else if(cars.distance > maxDistance) {
                winners.clear()
                winners.add(cars.name)
                maxDistance = cars.distance
            }
        }

        return winners
    }
}