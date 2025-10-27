package racingcar

class RacingGame(
    private val cars: List<Car>,
    private val rule: MoveRule
) {
    fun play() {
        cars.forEach { it.move(rule) }
    }

    fun resultWinner(): List<String> {
        // 가장 멀리 이동한 자동차의 값을 반환
        val maxPosition = cars.maxOf { it. position }
        // 가장 멀리 이동한 자동차의 이름만 매핑
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}