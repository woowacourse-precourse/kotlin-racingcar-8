package racingcar.util

object Parser {
    fun splitByComma(input: String): List<String> {
        return input.split(",")
            .map { it.trim() }
    }
}