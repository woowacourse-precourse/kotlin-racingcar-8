package racingcar

class Car(
	val name: String
) {
	companion object {
		private const val START_DISTANCE = 0
	}

	var position = START_DISTANCE
		private set

	fun moveForward() {
		position++
	}
}