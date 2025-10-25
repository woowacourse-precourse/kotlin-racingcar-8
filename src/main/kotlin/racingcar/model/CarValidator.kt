package racingcar.model

class CarValidator {
    fun parseAndValidateCarName(input: String): List<String> {
        val names = input.split(",").map { it.trim() }
        validateCarName(names)

        return names
    }

    private fun validateCarName(names: List<String>) {
        require(names.all { it.isNotBlank() }) { throw IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다." ) }
        require(names.all { it.length <= 5 }) { throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.") }
        require(names.distinct().size == names.size) { throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.") }
    }
}