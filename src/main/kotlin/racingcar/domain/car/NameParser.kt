package racingcar.domain.car

object NameParser {
    fun splitByComma(input: String): List<String> {
        return input.split(",")
            .map { it.trim() }
    }
}