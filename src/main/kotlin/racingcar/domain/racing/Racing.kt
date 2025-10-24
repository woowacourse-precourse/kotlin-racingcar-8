package racingcar.domain.racing

class Racing(
    private val _roundResults: MutableList<String> = mutableListOf(),
    private val _winners: MutableList<String> = mutableListOf()
) {
    val roundResults: String get() = _roundResults.joinToString("\n\n")
    val winners: String get() = _winners.joinToString(", ")

    fun canMove(n: Int): Boolean {
        return n >= MIN
    }

    fun saveRoundResults(round: Round) {
        _roundResults.add(round.roundResult)
    }

    fun saveWinners(winners: List<String>) {
        _winners.addAll(winners)
    }

    companion object {
        private const val MIN: Int = 4
    }
}