package racingcar.util

object InputParser {
    const val COMMA = ','

    fun parseCarNames(input: String): List<String> {
        return input.split(COMMA)
    }
}