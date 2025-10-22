package racingcar.util

import racingcar.domain.ErrorType

object Parser {
    val defaultDelimiters = listOf(',')

    /**
     * 주어진 문자열을 지정된 Delimiters로 구분한 결과를 반환한다.
     *
     * @param input 비어있지 않은, 입력된 문자열
     * @return 구분자에 의해 분리된 String List
     */
    fun splitWithDelimiters(input: String, delimiters: List<Char> = defaultDelimiters): List<String>{
        val regex = delimiters.joinToString(separator = "", prefix = "[", postfix = "]") { Regex.escape(it.toString()) }.toRegex()
        return input.split(regex)
    }

    /**
     * 주어진 문자열을 숫자로 변환하여 반환한다.
     *
     * @param input 비어있지 않은, 입력된 문자열
     * @return 입력된 문자열을 Int로 변환한 결과
     * @throws IllegalArgumentException Int로 변환할 수 없는 경우 에러 발생
     */
    fun parseInt(input: String): Int {
        val result = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorType.INVALID_NUMBER.message)
        return result
    }
}