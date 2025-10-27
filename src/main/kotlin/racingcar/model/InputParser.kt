package racingcar.model

const val CAR_NAME_REGEX = "^[A-Za-z0-9]{1,5}(,[A-Za-z0-9]{1,5})*$"

class InputParser {

    fun parseCar(input: String): List<String> {
        if (!validateCar(input)) {
            throw IllegalArgumentException("Invalid car input")
        }
        return input.split(",")
    }

    fun parseTime(input: String): Int {
        val result = input.toIntOrNull()
        return result ?: throw IllegalArgumentException("Invalid time input")
    }

    private fun validateCar(input: String): Boolean {
        return Regex(CAR_NAME_REGEX).matches(input)
    }


}