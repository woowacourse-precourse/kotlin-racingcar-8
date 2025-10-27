package racingcar.model.repository

interface NameRule {
    fun validate(names: List<String>)
}