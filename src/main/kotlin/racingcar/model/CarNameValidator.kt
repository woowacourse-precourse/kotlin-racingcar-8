package racingcar.model

object CarNameValidator {

    fun validateCarName(carNames: List<String>) {
        carNames.forEach { name ->
            require(name.length in 1..5) { "각 자동차의 이름의 길이는 1~5자 이어야 합니다."}
        }
    }

}