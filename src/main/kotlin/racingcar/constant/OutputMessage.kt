package racingcar.constant

enum class OutputMessage(val text: String) {
    ROUND_RESULT("%s : %s");

    fun format(name: String, round: Int): String {
        return text.format(name, "-".repeat(round))
    }
}