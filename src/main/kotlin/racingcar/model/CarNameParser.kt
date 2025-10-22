package racingcar.model

object CarNameParser {

    fun parseCarsNames(rawCarNames: String): List<String> {
        val carNames = rawCarNames.split(",").toList()
        return carNames
    }
}