package racingcar.model

class CarNameValidator {
    fun validateCarName(carNames: List<String>) {
        carNames.forEach { name ->
            require(name.length <= 5)
        }
    }
}