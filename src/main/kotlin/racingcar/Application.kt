package racingcar

fun main() {
	val (inputNames, inputTryCount) = InputView.readInput()

	val names = InputParser.parseNames(inputNames)
	val tryCount = InputParser.parseTryCount(inputTryCount)

	InputValidator.validateName(names)
	InputValidator.validateTryCount(tryCount)

	val cars = names.map { name ->
		Car(name)
	}

	Racing.racingStart(cars, tryCount)
}
