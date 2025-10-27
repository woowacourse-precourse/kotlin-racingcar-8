package racingcar

object InputParser {
	private const val DELIMITER = ","

	fun parseNames(inputNames: String): List<String> {
		return inputNames.split(DELIMITER)
	}

	fun parseTryCount(inputTryCount: String): Int {
		val tryCount = inputTryCount.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")

		return tryCount
	}
}