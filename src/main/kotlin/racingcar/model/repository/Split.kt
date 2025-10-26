package racingcar.model.repository

interface Split {
    fun split(carNames: String): List<String>
}