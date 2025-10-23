package racingcar.model

class RacingGame(private val carNames: List<String>, private val tries: String) {
    private val cars = carNames.map { Car(it) }
}
