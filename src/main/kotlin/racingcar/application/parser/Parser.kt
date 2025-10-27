package racingcar.application.parser

interface Parser<out O> {
    fun parse(input: String): O
}