package racingcar.util

object Util {
    fun splitByComma(input: String): List<String> {
        return input.split(",")
            .map { it.trim() }
    }
}