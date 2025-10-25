package racingcar.model

class RacingCarService {
    fun parseCarNameInput(input: String): List<Car> {
        return input.split(",").map { name -> Car(name.trim()) }
    }

    fun playRace(players: List<Car>) {
        players.forEach { it.move() }
    }

    fun getWinPlayers(players: List<Car>): List<String> {
        val maxPosition = players.maxOfOrNull { it.position }

        return players.filter { it.position == maxPosition }.map { it.name }
    }
}