package racingcar.domain

interface GameValidator {
    fun validateCarNames(namesInput: String)
    fun validateRaceCount(countInput: String): Int
}
