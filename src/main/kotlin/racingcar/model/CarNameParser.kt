package racingcar.model

class CarNameParser {

    fun parseCarsNames(rawCarNames: String): List<String> {
        val carNames = rawCarNames.split(",").toList()
        return carNames
    }

    fun validateCarName(carNames: List<String>) {
        carNames.forEach { name ->
            require(name.length <= 5)
        }
    }
}