package racingcar.model

class RacingCarService {
    fun parseCarNameInput(input: String): List<Car> {
        return input.split(",").map { name -> Car(name.trim()) }
    }

    fun playRace(players: List<Car>) {
        players.forEach { it.move() }
    }
}