package racingcar.constant

enum class OutputMessage(val text: String) {
    TITLE("실행 결과"),
    ROUND_RESULT("%s : %s"),
    WINNERS("최종 우승자 : %s");

    fun format(vararg args: Any): String {
        return text.format(*args)
    }
}