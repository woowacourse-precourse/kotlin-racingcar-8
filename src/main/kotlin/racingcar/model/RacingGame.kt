package racingcar.model

class RacingGame(carNames: List<String>) {
    private val cars = initCarNames(carNames).map { Car(it) }

    fun playRound(): List<Car> {
        cars.forEach { it.move() }
        return cars
    }

    fun getWinners(): List<Car> {
        val maxDistance = cars.maxOf { it.getDistance() }
        return cars.filter { it.getDistance() == maxDistance }
    }

    private fun initCarNames(names: List<String>): List<String> {
        val nameCount = names.groupingBy { it }.eachCount()
        val currentCount = mutableMapOf<String, Int>()
        val result = mutableListOf<String>()

        names.forEach { name ->
            val count = currentCount.getOrDefault(name, 0) + 1
            currentCount[name] = count

            if (nameCount[name]!! > 1) {
                result.add("$name#$count")
            } else {
                result.add(name)
            }
        }
        return result
    }
}
