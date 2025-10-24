package racingcar.util

object CarNameParser {

    private const val DELIMITER = ","

    fun parse(input: String): List<String> {
        return input.split(DELIMITER)
            .map { it.trim() }
            .filter { it.isNotBlank() }
    }
}