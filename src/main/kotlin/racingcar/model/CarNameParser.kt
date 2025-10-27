package racingcar.model

object CarNameParser {

    private const val NAME_SEPARATOR = ","

    fun parseCarsNames(rawCarNames: String): List<String> {
        val carNames = rawCarNames.split(NAME_SEPARATOR).toList()
        return carNames
    }
}