package racingcar.model.repository

interface Converter {
    fun toInt(attempt: String): Int
}