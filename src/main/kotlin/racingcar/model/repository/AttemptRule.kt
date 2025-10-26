package racingcar.model.repository

interface AttemptRule {
    fun validator(attempt: String)
}