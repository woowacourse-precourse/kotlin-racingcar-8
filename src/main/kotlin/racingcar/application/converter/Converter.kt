package racingcar.application.converter

interface Converter<out O> {
    fun convert(input: String): O
}