package racingcar.util

import racingcar.domain.ErrorType

object Parser {
    // 확장성을 위해 List로 정의
    val defaultDelimiters = listOf(',')

    /** 주어진 문자열 [input]을 지정된 [delimiters]로 구분한 결과를 반환한다. */
    fun splitWithDelimiters(input: String, delimiters: List<Char> = defaultDelimiters): List<String> {
        val regex = delimiters.joinToString(separator = "", prefix = "[", postfix = "]") { Regex.escape(it.toString()) }
            .toRegex()
        return input.split(regex)
    }

    /** 주어진 문자열 [input]을 숫자로 변환하여 반환한다. */
    fun parseInt(input: String): Int =
        input.toIntOrNull() ?: throw IllegalArgumentException(ErrorType.INVALID_NUMBER.message)
}