package racingcar.model

class RacingCarService {
    fun parseCarNameInput(input: String): List<String> {
        return input.split(",").map { it.trim() }
    }

    fun getRacingPlayers(names: List<String>): List<Car> {
        val carNames = mutableSetOf<String>()
        return names.map {
            if (it.isEmpty() || carNames.contains(it)) throw IllegalArgumentException()
            carNames.add(it)
            Car(it)
        }
    }

    fun playRace(players: List<Car>) {
        players.forEach { it.move() }
    }

    fun getWinPlayers(players: List<Car>): List<String> {
        val maxPosition = players.maxOfOrNull { it.position }

        return players.filter { it.position == maxPosition }.map { it.name }
    }
}