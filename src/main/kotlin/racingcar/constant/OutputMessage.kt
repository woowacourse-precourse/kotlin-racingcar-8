package racingcar.constant

enum class OutputMessage(val text: String) {
    ROUND_RESULT("%s : %s"),
    WINNERS("최종 우승자 : %s");

    fun format(vararg args: Any): String {
        return text.format(*args)
    }
}