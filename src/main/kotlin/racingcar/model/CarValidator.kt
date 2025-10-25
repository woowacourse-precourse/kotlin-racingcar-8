package racingcar.model

class CarValidator {
    fun parseAndValidateCarName(input: String): List<String> {
        val names = input.split(",").map { it.trim() }

        return names
    }
}